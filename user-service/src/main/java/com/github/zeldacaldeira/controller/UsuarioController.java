package com.github.zeldacaldeira.controller;

import com.github.zeldacaldeira.model.usuario.CadastroDTO;
import com.github.zeldacaldeira.model.usuario.Usuario;
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

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios() {
        return usuarioService.listaUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Optional<Usuario>> listaUsuarioPorId(@PathVariable Long id) {
        return usuarioService.listaUsuarioById(id).isPresent() ?
                ResponseEntity.ok(usuarioService.listaUsuarioById(id)) :
                ResponseEntity.notFound().build();
    }

    @PostMapping("/usuarios/cadastra")
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody CadastroDTO cadastroDTO) {
        Usuario usuario = usuarioService.salvaUsuario(cadastroDTO);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuarios/deleta/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        if (usuarioService.deletaUsuario(id)) {
            usuarioService.deletaUsuario(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
