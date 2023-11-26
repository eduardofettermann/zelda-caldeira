package com.github.zeldacaldeira.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI custom () {
        return new OpenAPI().info(new Info().title("Zelda Caldeira").version("1.0.0")
                .license(new License().name("System license").url("https://github.com/eduardofettermann/zelda-caldeira/tree/main"))
        );
    }
}
