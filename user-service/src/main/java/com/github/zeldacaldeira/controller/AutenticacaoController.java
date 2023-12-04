package com.github.zeldacaldeira.controller;

import com.github.zeldacaldeira.infra.security.TokenService;
import com.github.zeldacaldeira.model.usuario.CadastroDTO;
import com.github.zeldacaldeira.model.usuario.LoginDTO;
import com.github.zeldacaldeira.model.usuario.LoginResponseDTO;
import com.github.zeldacaldeira.model.usuario.Usuario;
import com.github.zeldacaldeira.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zeldacaldeira/autenticacao")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO loginDTO) {
        var loginESenha = new UsernamePasswordAuthenticationToken(loginDTO.login(), loginDTO.senha());
        var autenticacao = this.authenticationManager.authenticate(loginESenha);

        var token = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroDTO cadastroDTO) {
        if (this.repository.findByLogin(cadastroDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String senhaCriptografada = new BCryptPasswordEncoder().encode(cadastroDTO.senha());
        Usuario novoUsuario = new Usuario(cadastroDTO);
        novoUsuario.setSenha(senhaCriptografada);

        this.repository.save(novoUsuario);

        return ResponseEntity.ok().build();
    }
}
