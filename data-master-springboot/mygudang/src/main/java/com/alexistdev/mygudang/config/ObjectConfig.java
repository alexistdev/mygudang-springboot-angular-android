package com.alexistdev.mygudang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ObjectConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods(
                        HttpMethod.POST.name(), HttpMethod.GET.name(), HttpMethod.DELETE.name(),
                        HttpMethod.PUT.name(), HttpMethod.PATCH.name());
//				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods(
//						HttpMethod.POST.name(), HttpMethod.GET.name(), HttpMethod.DELETE.name(),
//						HttpMethod.PUT.name(), HttpMethod.PATCH.name());

            }
        };
    }
}
