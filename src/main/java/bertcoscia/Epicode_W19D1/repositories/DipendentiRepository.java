package bertcoscia.Epicode_W19D1.repositories;

import bertcoscia.Epicode_W19D1.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DipendentiRepository extends JpaRepository<Dipendente, UUID> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<Dipendente> findByEmail(String email);

}
