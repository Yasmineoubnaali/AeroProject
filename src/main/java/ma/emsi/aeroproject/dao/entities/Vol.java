package ma.emsi.aeroproject.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateDepart;
    private Date dateArriver;
    private String villeArriver;
    private String villeDestination;
    private String classe;
    private Integer nbrPersonne;





}
