package ma.emsi.aeroproject.dao.repository;

import jakarta.transaction.Transactional;
import ma.emsi.aeroproject.dao.entities.Aeroport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional
public interface AeroportRepository extends JpaRepository<Aeroport,Integer> {
    @Override
    Optional<Aeroport> findById(Integer id);
}
