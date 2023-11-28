package com.github.gatewayservice.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceGatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service-saveUser", r -> r.path("/zeldacaldeira/usuarios/cadastrar")
                        .uri("http://localhost:8081"))
                .route("user-service-getAllUsers", r -> r.path("/zeldacaldeira/usuarios")
                        .uri("http://localhost:8081"))
                .route("user-service-getUserById", r -> r.path("/zeldacaldeira/usuarios/**")
                        .filters(f -> f.rewritePath("/(?<id>.*)", "/${id}"))
                        .uri("http://localhost:8081"))
                .route("user-service-updateUserById", r -> r.path("/zeldacaldeira/usuarios/atualizar/**")
                        .filters(f -> f.rewritePath("/(?<id>.*)", "/${id}"))
                        .uri("http://localhost:8081"))
                .route("user-service-deleteUserById", r -> r.path("/zeldacaldeira/usuarios/deletar/**")
                        .filters(f -> f.rewritePath("/(?<id>.*)", "/${id}"))
                        .uri("http://localhost:8081"))
                .build();
    }
}
