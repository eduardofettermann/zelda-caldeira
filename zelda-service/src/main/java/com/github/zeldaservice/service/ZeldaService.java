package com.github.zeldaservice.service;

import com.github.zeldaservice.components.ZeldaWebClient;
import com.github.zeldaservice.model.Jogo;
import com.github.zeldaservice.model.TodosJogosResponse;
import com.github.zeldaservice.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Optional;

@Service
public class ZeldaService {
    @Autowired
    private ZeldaWebClient webClient;
    @Autowired
    private JogoRepository repository;

    public TodosJogosResponse getTodosJogosResponse() {
        return webClient.getTodosJogos();
    }

    public Optional<Jogo> getJogoById(String id) throws WebClientResponseException {
        return verificaSeTemJogo(id) ? repository.findById(id) : Optional.empty();
    }

    public boolean verificaSeTemJogo(String id) {
        if (repository.existsById(id)) {
            return true;
        }
        try {
            repository.save(webClient.getJogo(id).getJogoEncontrado());
            return true;
        } catch (WebClientResponseException e) {
            return false;
        }
    }
}
