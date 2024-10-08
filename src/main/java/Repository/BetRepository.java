package Repository;

import beans.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Long> {
    // Métodos personalizados, se necessário
}
