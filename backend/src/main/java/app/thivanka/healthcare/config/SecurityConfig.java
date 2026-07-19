package app.thivanka.healthcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // ✅ new style for Spring Security 6
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // allow all requests (dev mode)
            );
        return http.build();
    }
}
