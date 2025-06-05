package top.sob.osa.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import top.sob.osa.server.dao.mongo.MongoCsrfTokenRepository;

@Configuration
@Import(OsaServerSecurityConfiguration.class)
public class OsaServerSecurityChainConfiguration {

    public static final String AUTH_ADMIN = "Auth-Admin";

    public static final int DEFAULT_TOKEN_VALIDITY = 86400 * 30;

    @Bean
    public SecurityFilterChain osaServerSecurityFilterChain(HttpSecurity http, MongoCsrfTokenRepository mongoCsrfTokenRepository, PersistentTokenRepository persistentTokenRepository) throws Exception {

        http.cors(CorsConfigurer::disable);

        http.csrf(cfg ->
                cfg.csrfTokenRepository(mongoCsrfTokenRepository));

        http.authorizeHttpRequests(reg ->
                reg.requestMatchers("/osa/register")
                        .anonymous()
                        .requestMatchers("/system/**")
                        .hasAuthority(AUTH_ADMIN)
                        .requestMatchers("/public/**")
                        .permitAll());

        http.formLogin(cfg ->
                cfg.usernameParameter("username")
                        .passwordParameter("password"));

        http.rememberMe(cfg ->
                cfg.tokenRepository(persistentTokenRepository)
                        .tokenValiditySeconds(DEFAULT_TOKEN_VALIDITY));

        http.logout(cfg ->
                cfg.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")));

        return http.build();
    }
}
