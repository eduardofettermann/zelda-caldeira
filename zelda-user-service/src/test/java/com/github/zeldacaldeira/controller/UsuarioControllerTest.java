package com.github.zeldacaldeira.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.github.zeldacaldeira.model.usuario.Usuario;
import com.github.zeldacaldeira.service.UsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
@AutoConfigureMockMvc
class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioService usuarioService;

//    @Test
//    void testRetornarUsuarios_DeveRetornarListaDeUsuarios() throws Exception {
//        // Arrange
//        Usuario usuario1 = new Usuario("João", 25);
//        Usuario usuario2 = new Usuario("Maria", 30);
//        List<Usuario> usuarios = List.of(usuario1, usuario2);
//        when(usuarioService.getUsuarios()).thenReturn(usuarios);
//
//        // Act e Assert
//        mockMvc.perform(get("/zeldacaldeira/usuarios"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isArray())
//                .andExpect(jsonPath("$[0].nome").exists())
//                .andExpect(jsonPath("$[1].nome").exists());
//    }

//    @Test
//    void testRetornarUsuarioPorId_Existente_DeveRetornarUsuario() throws Exception {
//        // Arrange
//        Long userId = 1L;
//        Usuario usuario = new Usuario("João", 25);
//        Optional<Usuario> optionalUsuario = Optional.of(usuario);
//        when(usuarioService.getUsuarioById(userId)).thenReturn(optionalUsuario);
//
//        // Act e Assert
//        mockMvc.perform(get("/zeldacaldeira/usuarios/{id}", userId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nome").exists());
//    }

    @Test
    void testRetornarUsuarioPorId_NaoExistente_DeveRetornarNotFound() throws Exception {
        // Arrange
        Long userId = 1L;
        Optional<Usuario> optionalUsuario = Optional.empty();
        when(usuarioService.getUsuarioById(userId)).thenReturn(optionalUsuario);

        // Act e Assert
        mockMvc.perform(get("/zeldacaldeira/usuarios/{id}", userId))
                .andExpect(status().isNotFound());
    }

//    @Test
//    void testSalvarUsuario_DeveRetornarUsuarioSalvo() throws Exception {
//        // Arrange
//        UsuarioDTO usuarioDTO = new UsuarioDTO("Matheus", 60);
//        Usuario usuarioSalvo = new Usuario("Matheus", 60);
//        when(usuarioService.saveUsuario(any(UsuarioDTO.class))).thenReturn(usuarioSalvo);
//
//        // Act e Assert
//        mockMvc.perform(post("/zeldacaldeira/usuarios/cadastrar")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(usuarioDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nome").value("Matheus"))
//                .andExpect(jsonPath("$.idade").value(60));
//    }

//    @Test
//    void testAtualizarUsuario_DeveRetornarUsuarioAtualizado() throws Exception {
//        // Arrange
//        Long idDoUsuario = 1L;
//        UsuarioDTO atualizacaoDoUsuario = new UsuarioDTO("Diego", 60);
//        Usuario usuarioAtualizado = new Usuario("Diego", 60);
//        when(usuarioService.updateUsuario(idDoUsuario, atualizacaoDoUsuario)).thenReturn(usuarioAtualizado);
//
//        // Act e Assert
//        mockMvc.perform(put("/zeldacaldeira/usuarios/atualizar/{id}", idDoUsuario)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(atualizacaoDoUsuario)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nome").value("Diego"))
//                .andExpect(jsonPath("$.idade").value(60));
//    }

    @Test
    void testDeletarUsuario_DeveRetornarNoContent() throws Exception {
        // Arrange
        Long userId = 1L;
        when(usuarioService.deletarUsuario(userId)).thenReturn(true);

        // Act e Assert
        mockMvc.perform(delete("/zeldacaldeira/usuarios/deletar/{id}", userId))
                .andExpect(status().isNoContent());
    }
}
