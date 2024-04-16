package ma.emsi.aeroproject.dao.repository;

import ma.emsi.aeroproject.dao.entities.Billet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BilletRepository extends JpaRepository<Billet,Integer> {
    @Override
    Optional<Billet> findById(Integer id);

}
