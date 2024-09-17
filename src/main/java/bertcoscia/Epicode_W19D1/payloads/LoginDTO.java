package bertcoscia.Epicode_W19D1.payloads;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(
        @NotEmpty(message = "Username obbligatorio")
        String username,
        @NotEmpty(message = "Password obbligatoria")
        String password
) {
}
