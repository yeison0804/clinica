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
public class Atencion implements Serializable {
    @Id
    String codigo;
    @Column(nullable = false)
    String diagnostico;
    @Column(nullable = false)
    String tratamiento;
    @Column(nullable = false)
    String notas_medicas;

    @OneToOne
    @JoinColumn(name="Codigo_cita")
    Cita cita;

}
