package ma.emsi.aeroproject.dao.repository;

import ma.emsi.aeroproject.dao.entities.Aeroport;
import ma.emsi.aeroproject.dao.entities.Bagage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BagageRepository extends JpaRepository<Bagage,Integer> {
    @Override
    Optional<Bagage> findById(Integer id);
}
