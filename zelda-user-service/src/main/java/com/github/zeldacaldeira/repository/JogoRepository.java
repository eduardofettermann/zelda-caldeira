package com.github.zeldacaldeira.repository;


import com.github.zeldacaldeira.model.jogo.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, String> {
}
