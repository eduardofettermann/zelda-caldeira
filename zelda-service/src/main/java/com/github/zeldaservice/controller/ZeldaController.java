package com.github.zeldaservice.controller;

import com.github.zeldaservice.model.Jogo;
import com.github.zeldaservice.model.TodosJogosResponse;
import com.github.zeldaservice.service.ZeldaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestController
@RequestMapping("/zeldacaldeira")
public class ZeldaController {
    @Autowired
    private ZeldaService service;

    @GetMapping("/jogos")
    public ResponseEntity<TodosJogosResponse> getTodosJogos() {
        return ResponseEntity.ok(service.getTodosJogosResponse());
    }

    @GetMapping("/jogos/{id}")
    public ResponseEntity<Jogo> getJogo(@PathVariable String id) {
        try {
            return ResponseEntity.ok(service.getJogoById(id));
        } catch (WebClientResponseException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
