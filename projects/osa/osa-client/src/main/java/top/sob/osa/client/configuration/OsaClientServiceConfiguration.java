package top.sob.osa.client.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import top.sob.osa.client.service.OsaTemplate;

@Configuration
public class OsaClientServiceConfiguration {

    public OsaTemplate osa(RestTemplate rest, String osaUrl) {
        return new OsaTemplate(rest, osaUrl);
    }

}
