package com.github.zeldacaldeira.controller;

import com.github.zeldacaldeira.model.Usuario;
import com.github.zeldacaldeira.model.UsuarioAtualizado;
import com.github.zeldacaldeira.repository.UsuarioInterinoRepository;
import com.github.zeldacaldeira.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zeldacaldeira")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioInterinoRepository usuarioInterinoRepository;

    @GetMapping("/usuarios")
    public List<Usuario> retornarUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Optional<Usuario>> retornarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id).isPresent() ?
                ResponseEntity.ok(usuarioService.getUsuarioById(id)) :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/usuarios/cadastrar")
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/usuarios/atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioAtualizado atualizacaoDoUsuario) {
        return usuarioService.updateUsuario(id, atualizacaoDoUsuario) != null ?
                ResponseEntity.ok(usuarioService.updateUsuario(id, atualizacaoDoUsuario)) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/usuarios/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
