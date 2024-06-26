package ma.emsi.aeroproject.dao.repository;

import ma.emsi.aeroproject.dao.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    @Override
    Optional<Reservation> findById(Integer id);
}
