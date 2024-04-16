package ma.emsi.aeroproject.dao.repository;

import jakarta.transaction.Transactional;
import ma.emsi.aeroproject.dao.entities.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional
public interface VolRepository extends JpaRepository<Vol,Integer> {
    @Override
    Optional<Vol> findById(Integer id);
}
