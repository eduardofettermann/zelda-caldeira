package com.github.zeldacaldeira.controller;

import com.github.zeldacaldeira.model.Usuario;
import com.github.zeldacaldeira.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zelda+caldeira")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios/cadastrar")
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public Optional<Usuario> retornarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @GetMapping("/usuarios")
    public List<Usuario> retornarUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PutMapping("/usuarios/alterar")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestParam(value = "id") Long id,
                                                    @RequestBody Usuario usuarioAtualizado) {
        usuarioService.updateUsuario(id, usuarioAtualizado);
        return usuarioAtualizado != null & usuarioService.getUsuarioById(id) != null ?
                ResponseEntity.ok(usuarioAtualizado) :
                ResponseEntity.notFound().build();
    }
}
