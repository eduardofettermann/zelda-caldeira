package com.github.zeldaservice.service;

import com.github.zeldaservice.components.ZeldaWebClient;
import com.github.zeldaservice.model.Jogo;
import com.github.zeldaservice.model.TodosJogosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class ZeldaService {
    @Autowired
    private ZeldaWebClient webClient;

    public TodosJogosResponse getTodosJogosResponse() {
        return webClient.getTodosJogos();
    }

    public Jogo getJogoById(String id) throws WebClientResponseException {
        return webClient.getJogo(id).getJogoEncontrado();
    }
}
