package com.github.zeldacaldeira.controller;

import com.github.zeldacaldeira.model.jogo.Jogo;
import com.github.zeldacaldeira.model.jogo.TodosJogosResponse;
import com.github.zeldacaldeira.service.ZeldaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return service.getJogoById(id).isPresent() ?
                ResponseEntity.ok(service.getJogoById(id).get()) :
                ResponseEntity.notFound().build();
    }
}
