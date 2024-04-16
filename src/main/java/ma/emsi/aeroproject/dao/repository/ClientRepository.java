package ma.emsi.aeroproject.dao.repository;

import jakarta.transaction.Transactional;
import ma.emsi.aeroproject.dao.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

@Transactional
public interface ClientRepository extends JpaRepository<Client,Integer> {

    Page<Client> findByNomCompContains(String keyword, Pageable pageable);
    /*
    @Override
    Optional<Client> findById(Integer id);*/
}
