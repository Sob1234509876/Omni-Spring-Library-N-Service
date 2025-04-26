package top.sob.osp.client.runner;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import top.sob.osp.app.annotation.Plugin;
import top.sob.osp.client.internal.Matches;

import java.util.Map;
import java.util.Objects;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Component
public class ServerPluginMatchRunner implements ApplicationRunner, ApplicationContextAware {

    @NonNull
    RestTemplate restTemplate;

    @NonNull
    ApplicationContext applicationContext;

    @NonNull
    String serverUrl;

    @SuppressWarnings("unchecked")
    @Override
    public void run(ApplicationArguments args) {
        Objects.requireNonNull(args);

        var pluginUrl = serverUrl + "/api/plugin/";
        var plugins = applicationContext.getBeansWithAnnotation(Plugin.class);

        for (var plugin : plugins.entrySet()) {
            var meta = restTemplate.getForEntity(pluginUrl + plugin.getKey(), Map.class);

            if (!Matches.match(plugin.getValue(), (Map<String, String>) meta))
                throw new IllegalArgumentException("Plugin " + plugin.getKey() + " does not match the plugin on the server");
        }
    }
}
