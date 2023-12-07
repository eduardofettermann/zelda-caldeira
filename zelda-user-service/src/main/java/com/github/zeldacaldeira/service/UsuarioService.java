package com.github.zeldacaldeira.service;

import com.github.zeldacaldeira.model.jogo.Jogo;
import com.github.zeldacaldeira.model.usuario.AtualizacaoUsuario;
import com.github.zeldacaldeira.model.usuario.Usuario;
import com.github.zeldacaldeira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ZeldaService zeldaService;
    public Usuario favoritarJogo(String idDoJogo, long idDoUsuario) throws DataIntegrityViolationException {
        Optional<Usuario> usuario = usuarioRepository.findById(idDoUsuario);
        Optional<Jogo> jogo = zeldaService.getJogoById(idDoJogo);
        usuario.get().getJogosFavoritos().add(jogo.get());
        usuarioRepository.save(usuario.get());
        return usuario.get();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        if (usuarioRepository.existsById(id)) {
            return usuarioRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }


    public Usuario updateUsuario(Long id, AtualizacaoUsuario atualizacaoDoUsuario) {
        if (usuarioRepository.existsById(id)) {
            Optional<Usuario> usuarioASerAtualizado = usuarioRepository.findById(id);
            Usuario usuario = new Usuario(atualizacaoDoUsuario);
            usuario.setSenha(usuarioASerAtualizado.get().getSenha());
            usuario.setJogosFavoritos(usuarioASerAtualizado.get().getJogosFavoritos());
            usuario.setLogin(usuarioASerAtualizado.get().getLogin());
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public boolean deletarUsuario(long id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
