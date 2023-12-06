package com.github.zeldaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class ZeldaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeldaServiceApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*") // Permitir solicitações de qualquer origem
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("Content-Type");
			}
		};
	}
}
