package br.com.fiap.beautytech.service;

import br.com.fiap.beautytech.models.Cliente;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.token.secret}")
    private String senhaToken;

    public String gerarToken(Cliente cliente) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(senhaToken);
            return JWT.create()
                    .withIssuer("BeautyTech")
                    .withSubject(cliente.getEmail())
                    .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar o token.");
        }
    }

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(senhaToken);
            return JWT.require(algorithm)
                    .withIssuer("BeautyTech").
                    build().
                    verify(token).
                    getSubject();
        } catch (JWTVerificationException e){
            throw new RuntimeException("Não foi possível validar o token JWT");
        }

    }
}
