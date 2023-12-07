package com.github.zeldacaldeira.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI custom () {
        return new OpenAPI().info(new Info().title("Zelda Caldeira").version("1.0.0")
                .description("\n" +
                        "The objective of this project is to create an innovative platform that connects enthusiasts of the renowned Zelda franchise.")
                .license(new License().name("Contact the developer").url("https://github.com/eduardofettermann/zelda-caldeira/tree/main"))
                .contact(new Contact().name("Find out more about Swagger").url("https://swagger.io/"))



        );
    }
}
