package com.github.zeldaservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {

    private String zeldaUrl;

    public BeanConfiguration(ZeldaConfiguration zeldaConfiguration) {
        this.zeldaUrl = zeldaConfiguration.zeldaBaseUrl;
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(zeldaUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
