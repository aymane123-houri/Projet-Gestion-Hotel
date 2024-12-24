package ma.gatewayservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebFluxSecurity
@CrossOrigin("http://localhost:4200/")
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(auth -> auth.pathMatchers("/actuator/health").permitAll())
                .authorizeExchange(auth -> auth.pathMatchers("/user-service/Utilisateurs/email/{email}").permitAll())
                .authorizeExchange(auth -> auth.pathMatchers("/receptionist-service/Administrator/email/{email}").permitAll())
                .authorizeExchange(auth -> auth.anyExchange().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {}));
        return http.build();
    }


}
