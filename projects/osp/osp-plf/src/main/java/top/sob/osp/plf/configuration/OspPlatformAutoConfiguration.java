package top.sob.osp.plf.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import top.sob.osp.plf.loader.AppClassLoader;
import top.sob.osp.plf.runner.PluginLoadingRunner;

@Data
@NoArgsConstructor
@Import(OspAppClassLoaderConfiguration.class)
@AutoConfiguration
public class OspPlatformAutoConfiguration {

    @Bean
    public PluginLoadingRunner pluginLoadingRunner(AppClassLoader appClassLoader) {
        return new PluginLoadingRunner(appClassLoader);
    }
}
