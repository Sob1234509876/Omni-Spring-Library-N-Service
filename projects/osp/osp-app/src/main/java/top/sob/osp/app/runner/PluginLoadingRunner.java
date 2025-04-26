package top.sob.osp.app.runner;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import top.sob.osp.app.annotation.Plugin;
import top.sob.osp.app.bean.PLD;
import top.sob.osp.app.loader.AppClassLoader;

import java.util.Objects;

@Slf4j
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Component
public class PluginLoadingRunner implements ApplicationRunner, BeanFactoryAware {

    BeanFactory beanFactory;

    @NonNull
    AppClassLoader appClassLoader;

    @Override
    public void run(ApplicationArguments args) throws ClassNotFoundException {
        Objects.requireNonNull(beanFactory);

        if (!(beanFactory instanceof BeanDefinitionRegistry registry))
            throw new AssertionError("BeanFactory is not a BeanDefinitionRegistry");

        var plugins = beanFactory.getBeanProvider(PLD.class);

        for (var plugin : plugins) {
            var p = appClassLoader.loadPluginClass(plugin);
            var name = "plugin" + p.getSimpleName();

            registry.registerBeanDefinition(name, new RootBeanDefinition(p));

            log.info("Registered plugin ({}) \"{}\", name: {}, version: {}", p.getName(), name, p.getAnnotation(Plugin.class).name(), p.getAnnotation(Plugin.class).version());
        }
    }
}
