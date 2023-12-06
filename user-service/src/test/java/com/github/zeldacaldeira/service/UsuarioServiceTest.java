//package com.github.zeldacaldeira.service;
//
//
//import com.github.zeldacaldeira.model.usuario.Usuario;
//import com.github.zeldacaldeira.repository.UsuarioRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UsuarioServiceTest {
//
//    @InjectMocks
//    private UsuarioService service;
//
//    @Mock
//    private UsuarioRepository repository;
//
//    private Usuario usuarioMockado;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        usuarioMockado = new Usuario(1L, "Rock Lee", 30);
//    }
//
//    @Test
//    @DisplayName("001 - Testa saveUsuario()")
//    public void deveRetornarUsuarioSalvoComSucesso() {
//        // Arrange
//        UsuarioDTO usuarioDto = new UsuarioDTO("Rock Lee", 30);
//        Usuario usuario = new Usuario(usuarioDto);
//        when(repository.save(any(Usuario.class))).thenReturn(usuario);
//
//        // Act
//        Usuario result = service.saveUsuario(usuarioDto);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(usuario, result);
//        verify(repository,times(1)).save(any(Usuario.class));
//    }
//
//    @Test
//    @DisplayName("002 - Testa getUsuarioById()")
//    public void deveRetornarUsuarioPeloIdComSucesso() {
//        // Arrange
//        when(repository.existsById(anyLong())).thenReturn(true);
//        when(repository.findById(anyLong())).thenReturn(Optional.of(usuarioMockado));
//
//        // Act
//        Optional<Usuario> result = service.getUsuarioById(1L);
//
//        // Assert
//        assertTrue(result.isPresent());
//        assertEquals(usuarioMockado, result.get());
//        verify(repository).findById(anyLong());
//    }
//
//    @Test
//    @DisplayName("003 - Testa getUsuarios()")
//    public void testGetAllUsuarios() {
//        // Arrange
//        when(repository.findAll()).thenReturn(Arrays.asList(usuarioMockado, mock(Usuario.class), mock(Usuario.class)));
//        List<Usuario> usuarios = service.getUsuarios();
//
//        // Assert
//        assertNotNull(usuarios);
//        assertEquals(3, usuarios.size());
//        verify(repository).findAll();
//    }
//
//    @Test
//    @DisplayName("004 - Testa updateUsuario()")
//    public void deveRetornarUsuarioAtualizado() {
//        // Arrange
//        Usuario usuario = mock(Usuario.class);
//        UsuarioDTO atualizacaoUsuario = new UsuarioDTO("Usuario atualizado", 20);
//        Usuario usuarioAtualizado = new Usuario(atualizacaoUsuario);
//        when(repository.existsById(usuario.getId())).thenReturn(true);
//        when(repository.save(any(Usuario.class))).thenReturn(usuarioAtualizado);
//
//        // Act
//        Usuario result = service.updateUsuario(usuario.getId(), atualizacaoUsuario);
//
//        // Assert
//        verify(repository, times(1)).existsById(usuario.getId());
//        verify(repository, times(1)).save(any(Usuario.class));
//        assertEquals(result, usuarioAtualizado);
//    }
//
//    @Test
//    @DisplayName("005 - Testa deleteById()")
//    public void deveDeletarUsuarioPeloId() {
//        // Arrange
//        when(repository.existsById(anyLong())).thenReturn(true);
//
//        // Act
//        boolean result = service.deletarUsuario(anyLong());
//
//        // Assert
//        assertTrue(result);
//        verify(repository).deleteById(anyLong());
//        verify(repository, times(1)).deleteById(anyLong());
//    }
//}