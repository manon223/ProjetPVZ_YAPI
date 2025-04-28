package com.oxyl.epf.coursepfback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permet d'ajouter un accès pour toutes les routes
                .allowedOrigins("http://localhost:5173")  // Ton frontend React
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Les méthodes HTTP permises
                .allowedHeaders("*")  // Autorise tous les headers
                .allowCredentials(true);  // Permet l'envoi de cookies / informations d'identification
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configure l'accès aux ressources, comme les images par exemple
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/images/", "classpath:/static/images/", "file:images/", "file:target/CoursEpfBack/images/");  // Remplace le chemin par celui où sont stockées tes images
    }
}