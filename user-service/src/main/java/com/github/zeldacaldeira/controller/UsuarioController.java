package com.github.zeldacaldeira.controller;

import com.github.zeldacaldeira.model.Usuario;
import com.github.zeldacaldeira.model.UsuarioDTO;
import com.github.zeldacaldeira.service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zeldacaldeira")
public class UsuarioController {

    private static final Logger logger = LogManager.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> retornarUsuarios() {
        logger.info("Obtendo todos os usuários");
        List<Usuario> usuarios = usuarioService.getUsuarios();
        logger.info("Total de usuários encontrados: {}", usuarios.size());
        return usuarios;
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Optional<Usuario>> retornarUsuarioPorId(@PathVariable Long id) {
        logger.info("Obtendo usuário com ID: {}", id);
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);

        if (usuario.isPresent()) {
            logger.info("Usuário encontrado: {}", usuario.get().getNome());
            return ResponseEntity.ok(usuario);
        } else {
            logger.warn("Usuário com ID {} não encontrado", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/usuarios/cadastrar")
    public Usuario salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        logger.info("Salvando novo usuário: {}", usuarioDTO.nome());
        Usuario novoUsuario = usuarioService.saveUsuario(usuarioDTO);
        logger.info("Novo usuário salvo com sucesso: {}", novoUsuario.getId());
        return novoUsuario;
    }

    @PutMapping("/usuarios/atualizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO atualizacaoDoUsuario) {
        logger.info("Atualizando usuário com ID: {}", id);
        Usuario usuarioAtualizado = usuarioService.updateUsuario(id, atualizacaoDoUsuario);

        if (usuarioAtualizado != null) {
            logger.info("Usuário atualizado com sucesso: {}", usuarioAtualizado.getId());
            return ResponseEntity.ok(usuarioAtualizado);
        } else {
            logger.warn("Usuário com ID {} não encontrado para atualização", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/usuarios/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        logger.info("Deletando usuário com ID: {}", id);

        if (usuarioService.deletarUsuario(id)) {
            logger.info("Usuário deletado com sucesso: {}", id);
            return ResponseEntity.ok().build();
        } else {
            logger.warn("Usuário com ID {} não encontrado para exclusão", id);
            return ResponseEntity.notFound().build();
        }
    }
}
