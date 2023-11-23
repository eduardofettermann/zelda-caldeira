package com.github.zeldacaldeira.service;

import com.github.zeldacaldeira.model.Usuario;
import com.github.zeldacaldeira.repository.UsuarioInterinoRepository;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioInterinoRepository usuarioInterinoRepository;

    public Optional<Usuario> getUsuarioById(long id) {
        return usuarioInterinoRepository.findById(id);
    }

    public List<Usuario> getUsuarios(){
        return usuarioInterinoRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioInterinoRepository.save(usuario);
    }

    public ResponseEntity<Usuario> updateUsuario(long idUsuarioDesatualizado, Usuario usuarioAtualizado){
        ResponseEntity<Usuario> response;
        if(usuarioInterinoRepository.existsById(idUsuarioDesatualizado)){
            usuarioAtualizado.setId(idUsuarioDesatualizado);
            usuarioAtualizado = usuarioInterinoRepository.save(usuarioAtualizado);
            response = ResponseEntity.ok(usuarioAtualizado);
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }
}
