package ma.emsi.aeroproject.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomPassager;
    private String prenomPassager;
    private String numeroPasseport;
    private Date dateReservation;
    private Integer nombrePlaces;
    private String statut;
    private Double prixTotal;
    private String typeSiege;
}
