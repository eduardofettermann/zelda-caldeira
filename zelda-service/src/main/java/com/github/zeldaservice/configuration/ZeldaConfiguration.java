package com.github.zeldaservice.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ZeldaConfiguration {

    @Value("${zelda.base-url}")
    public String zeldaBaseUrl;

    @Value("${zelda.jogos}")
    public String zeldaJogo;

    @Value("${zelda.jogos}")
    public String zeldaJogos;
}