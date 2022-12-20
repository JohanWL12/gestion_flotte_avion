package com.example.gestion_flotte_avion_ws_avion_ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
class GestionFlotteAvionWsApplicationTests {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
                registry.addMapping("/**").allowedOrigins("http://localhost").allowedMethods("*").allowedHeaders("*");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionFlotteAvionWsApplicationTests.class, args);
    }

}
