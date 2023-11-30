package com.github.zeldaservice.controller;

import com.github.zeldaservice.model.JogoResponse;
import com.github.zeldaservice.model.TodosJogosResponse;
import com.github.zeldaservice.service.ZeldaService;
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
    public ResponseEntity<JogoResponse> getJogo(@PathVariable String id) {
        return ResponseEntity.ok(service.getJogoById(id));
    }

}
