package bertcoscia.Epicode_W19D1.payloads;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(
        @NotEmpty(message = "Email obbligatoria")
        String email,
        @NotEmpty(message = "Password obbligatoria")
        String password
) {
}
