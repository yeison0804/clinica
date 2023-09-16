package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dia_Libre implements Serializable {
    @Id
    String codigo;

    @Column(nullable = false)
    String dia;

    @ManyToOne
    @JoinColumn(name="codigo_medico")
    Medico medico;

}
