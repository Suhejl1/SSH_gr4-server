package com.sshproject.bookstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Value("${cors.allowedOrigins}")
    private String allowedOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Add mappings for your API endpoints
                        .allowedOrigins(allowedOrigins) // Allow requests from localhost:3000
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific methods
                        .allowedHeaders("*"); // Allow all headers
            }
        };
    }
}
