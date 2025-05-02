package com.dentalclinic.clinic.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final  JwtAuthenticationFilter authenticationFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        auth ->{
                            // endpoints que no necesitan autenticacion
                            auth.requestMatchers("/api/v1/auth/**").permitAll();
                            auth.requestMatchers(HttpMethod.GET, "/odontologist/**").permitAll();
                            // endponints que necesitan algun tipo de rol especifico
                            auth.requestMatchers(HttpMethod.POST,"/odontologist/**").hasAnyAuthority("ADMIN");
                            auth.requestMatchers(HttpMethod.PUT,"/odontologist/**").hasAnyAuthority("ADMIN");
                            auth.requestMatchers(HttpMethod.DELETE,"/odontologist/**").hasAnyAuthority("ADMIN");
                            auth.requestMatchers("/patient/**").hasAnyAuthority("ADMIN");
                            auth.requestMatchers(HttpMethod.POST,"/patient/**").hasAnyAuthority("ADMIN");
                            auth.requestMatchers(HttpMethod.PUT,"/patient/**").hasAnyAuthority("ADMIN");
                            auth.requestMatchers(HttpMethod.DELETE,"/patient/**").hasAnyAuthority("ADMIN");

                            // endpoints que requieren autenticacion basica (tener al menos el rol de user)
                            auth.requestMatchers("/appointments/**").authenticated();
                            auth.anyRequest().authenticated();

                        })
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
