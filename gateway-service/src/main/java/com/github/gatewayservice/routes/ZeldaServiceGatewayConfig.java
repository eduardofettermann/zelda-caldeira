package com.github.gatewayservice.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZeldaServiceGatewayConfig {
    @Bean
    public RouteLocator customZeldaServiceRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("zelda-service-getAllGames", r -> r.path("/zeldacaldeira/jogos")
                        .uri("http://localhost:8082"))
                .route("zelda-service-getGameById", r -> r.path("/zeldacaldeira/jogos/**")
                        .filters(f -> f.rewritePath("/(?<id>.*)", "/${id}"))
                        .uri("http://localhost:8082"))
                .build();
    }
}
