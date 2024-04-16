package ma.emsi.aeroproject.dao.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bagage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double poids;
    private String etiquette;
    private String description;
    @ManyToOne
    private Client client;
}
