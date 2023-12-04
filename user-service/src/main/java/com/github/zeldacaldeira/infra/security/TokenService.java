package com.github.zeldacaldeira.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.github.zeldacaldeira.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${token.secreto.de.seguranca}")
    private String chaveSecreta;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algoritimo = Algorithm.HMAC256(chaveSecreta);
            String token = JWT.create()
                    .withIssuer("zelda-caldeira")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(gerarDataDeExpiracao())
                    .sign(algoritimo);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro durante a criação do token", exception);
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm algoritimo = Algorithm.HMAC256(chaveSecreta);
            return JWT.require(algoritimo)
                    .withIssuer("zelda-caldeira")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant gerarDataDeExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}