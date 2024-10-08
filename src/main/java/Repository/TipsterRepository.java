package Repository;

import beans.Tipster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipsterRepository extends JpaRepository<Tipster, Long> {
    // Métodos personalizados, se necessário
}
