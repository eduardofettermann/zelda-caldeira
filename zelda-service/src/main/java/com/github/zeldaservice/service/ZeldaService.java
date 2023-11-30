package com.github.zeldaservice.service;

import com.github.zeldaservice.components.ZeldaWebClient;
import com.github.zeldaservice.model.JogoResponse;
import com.github.zeldaservice.model.TodosJogosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZeldaService {
    @Autowired
    private ZeldaWebClient webClient;

    public TodosJogosResponse getTodosJogosResponse() {
        return webClient.getTodosJogos();
    }

    public JogoResponse getJogoById(String id) {
        return webClient.getJogo(id);
    }

}
