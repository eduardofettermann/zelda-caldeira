package com.github.zeldaservice.repository;

import com.github.zeldaservice.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogoRepository extends JpaRepository<Jogo, String> {
}
