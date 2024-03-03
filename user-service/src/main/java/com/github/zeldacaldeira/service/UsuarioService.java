package com.github.zeldacaldeira.service;

import com.github.zeldacaldeira.model.AtualizacaoUsuarioDTO;
import com.github.zeldacaldeira.model.CadastroDTO;
import com.github.zeldacaldeira.model.Usuario;
import com.github.zeldacaldeira.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> listaUsuarioById(Long id) {
        if (usuarioRepository.existsById(id)) {
            return usuarioRepository.findById(id);
        }
        return Optional.empty();
    }

    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario salvaUsuario(CadastroDTO cadastroDTO) {
        return usuarioRepository.save(new Usuario(cadastroDTO));
    }

    public Usuario atualizaUsuario(Long id, AtualizacaoUsuarioDTO atualizacaoUsuarioDTO){
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = usuarioRepository.findById(id).get();
            usuario.atualizarUsuario(atualizacaoUsuarioDTO);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public boolean deletaUsuario(long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
