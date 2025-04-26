package top.sob.osp.app.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.sob.osp.app.loader.AppClassLoader;
import top.sob.osp.app.runner.PluginLoadingRunner;

@Data
@NoArgsConstructor
@Import(OspAppClassLoaderConfiguration.class)
@Configuration(proxyBeanMethods = false)
public class OspAppConfiguration {

    @Bean
    public PluginLoadingRunner pluginLoadingRunner(AppClassLoader appClassLoader) {
        return new PluginLoadingRunner(appClassLoader);
    }
}
