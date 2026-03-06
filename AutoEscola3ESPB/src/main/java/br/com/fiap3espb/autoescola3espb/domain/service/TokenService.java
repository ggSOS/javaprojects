package br.com.fiap3espb.autoescola3espb.domain.service;

import br.com.fiap3espb.autoescola3espb.domain.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authorization.AuthoritiesAuthorizationManager;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;


    private String issuer = "Auto Escola 3ESPB;";


    public String gerarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o Token JWT");
        }
    }

    public String getSubject(String tokenJWT){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTCreationException exception){
            throw new RuntimeException("Token inválido ou expirado");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }

}
