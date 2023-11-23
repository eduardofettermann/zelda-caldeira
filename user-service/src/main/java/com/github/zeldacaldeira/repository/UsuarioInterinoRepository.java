package com.github.zeldacaldeira.repository;

import com.github.zeldacaldeira.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface UsuarioInterinoRepository extends JpaRepository<Usuario,Long>{
}
