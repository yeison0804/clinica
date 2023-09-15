package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    String diagnostico;
    String tratamiento;
    String notas_medicas;

    @OneToOne
    @JoinColumn(name="Codigo_cita")
    Cita cita;

}
