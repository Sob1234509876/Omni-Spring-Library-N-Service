package top.sob.osp.app.configuration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sob.osp.app.loader.AppClassLoader;

@Configuration(proxyBeanMethods = false)
public class OspAppClassLoaderConfiguration {

    public static final String DEFAULT_PATH = "./plugins";
    public static final String PATH_OPTION = "path";

    @Bean
    public AppClassLoader appClassLoader(ApplicationArguments args) {
        var paths = new String[]{DEFAULT_PATH};

        if (args.containsOption(PATH_OPTION)) {
            paths = args.getOptionValues(PATH_OPTION).toArray(new String[0]);
        }

        return new AppClassLoader(paths);
    }

}
