package com.github.zeldacaldeira.controller;

import com.github.zeldacaldeira.model.usuario.AtualizacaoUsuario;
import com.github.zeldacaldeira.model.usuario.Usuario;
import com.github.zeldacaldeira.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zeldacaldeira")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios/{idDoUsuario}/favoritar/{idDoJogo}")
    public ResponseEntity<Usuario> favoritarJogo(@PathVariable String idDoJogo, @PathVariable long idDoUsuario) throws DataIntegrityViolationException {
        try {
            Usuario usuario = usuarioService.favoritarJogo(idDoJogo, idDoUsuario);
            return ResponseEntity.ok(usuario);
        } catch (DataIntegrityViolationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Listar", description = "Método que retorna todos os usuários.", tags = "Usuário")
    @GetMapping("/usuarios")
    public List<Usuario> retornarUsuarios() {
        return usuarioService.getUsuarios();
    }

    @Operation(summary = "Busca por id", description = "Método que retorna um usuário.", tags = "Usuário")
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Optional<Usuario>> retornarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id).isPresent() ?
                ResponseEntity.ok(usuarioService.getUsuarioById(id)) :
                ResponseEntity.notFound().build();
    }

    @Operation(summary = "Atualizar", description = "Método que atualiza um usuário.", tags = "Usuário")
    @PutMapping("/usuarios/atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody AtualizacaoUsuario atualizacaoDoUsuario) {
        return usuarioService.updateUsuario(id, atualizacaoDoUsuario) != null ?
                ResponseEntity.ok(usuarioService.updateUsuario(id, atualizacaoDoUsuario)) :
                ResponseEntity.notFound().build();
    }

    @Operation(summary = "Deletar", description = "Método que deleta um usuário.", tags = "Usuário")
    @DeleteMapping("/usuarios/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        if (usuarioService.deletarUsuario(id)) {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
