package com.example.hrisproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Mengizinkan akses ke API
                .allowedOrigins("http://localhost:3000") // Ganti dengan URL frontend jika berbeda
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
