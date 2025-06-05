package top.sob.osa.client.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@Data
@NoArgsConstructor
@Import(OsaClientServiceConfiguration.class)
@AutoConfiguration
public class OsaClientAutoConfiguration {
}
