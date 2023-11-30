package com.github.zeldaservice.components;

import com.github.zeldaservice.configuration.ZeldaConfiguration;
import com.github.zeldaservice.model.JogoResponse;
import com.github.zeldaservice.model.TodosJogosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ZeldaWebClient {
    private final String todosJogosResource;
    private final String jogoResource;
    private final String baseUrl;
    @Autowired
    private WebClient webClient;

    public ZeldaWebClient(WebClient webClient, ZeldaConfiguration zeldaConfiguration) {
        this.todosJogosResource = zeldaConfiguration.zeldaJogos;
        this.jogoResource = zeldaConfiguration.zeldaJogo;
        this.baseUrl = zeldaConfiguration.zeldaBaseUrl;
        this.webClient = webClient;
    }

    public TodosJogosResponse getTodosJogos() {
        return webClient
                .method(HttpMethod.GET)
                .uri(todosJogosResource)
                .retrieve()
                .bodyToMono(TodosJogosResponse.class)
                .block();
    }

    // NUNCA MEXA NO CÓDIGO ABAIXO
    public JogoResponse getJogo(String id) {
        return webClient
                .method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path(jogoResource).pathSegment(id).build())
                .retrieve()
                .bodyToMono(JogoResponse.class)
                .block();
    }
}
