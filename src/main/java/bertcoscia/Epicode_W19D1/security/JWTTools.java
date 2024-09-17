package bertcoscia.Epicode_W19D1.security;

import bertcoscia.Epicode_W19D1.entities.Dipendente;
import bertcoscia.Epicode_W19D1.exceptions.UnauthorizedException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTools {
    @Value("${jwt.secret}")
    String secret;

    public String createToken(Dipendente dipendente) {
        return Jwts.builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .subject(String.valueOf(dipendente.getIdDipendente()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    public void verifyToken(String token) {
        try {

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw new UnauthorizedException("Problemi con il token. Effettua nuovamente il login");
        }
    }
}
