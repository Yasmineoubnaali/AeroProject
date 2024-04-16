package ma.emsi.aeroproject.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter@Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name" , length = 30, nullable = false)
    @NotEmpty
    @Size(min=5,max=30)
    private String nomComp;
    @NotEmpty
    private String email;
    @NotEmpty
    private String adress;
    @OneToMany(mappedBy = "client")
    private List<Bagage> bagages;
}
