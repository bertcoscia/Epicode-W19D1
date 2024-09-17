package bertcoscia.Epicode_W19D1.services;

import bertcoscia.Epicode_W19D1.entities.Dipendente;
import bertcoscia.Epicode_W19D1.exceptions.UnauthorizedException;
import bertcoscia.Epicode_W19D1.payloads.LoginDTO;
import bertcoscia.Epicode_W19D1.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    DipendentiService dipendentiService;

    @Autowired
    JWTTools jwtTools;

    public String checkCredentialsAndGenerateToken(LoginDTO body) {
        Dipendente found = this.dipendentiService.findByEmail(body.email());
        if (found.getPassword().equals(body.password())) {
            return this.jwtTools.createToken(found);
        } else {
            throw new UnauthorizedException("Email e/o password sbagliata");
        }
    }
}
