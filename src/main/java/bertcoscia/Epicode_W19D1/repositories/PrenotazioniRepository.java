package bertcoscia.Epicode_W19D1.repositories;

import bertcoscia.Epicode_W19D1.entities.Dipendente;
import bertcoscia.Epicode_W19D1.entities.Prenotazione;
import bertcoscia.Epicode_W19D1.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

    // @Query("SELECT p FROM Prenotazione p WHERE p.dipendente.idDipendente = :id AND p.viaggio.data = :data")
    boolean existsByDipendenteAndViaggioData(Dipendente dipendente, LocalDate data);

    boolean existsByDipendenteAndViaggio(Dipendente dipendente, Viaggio viaggio);
}
