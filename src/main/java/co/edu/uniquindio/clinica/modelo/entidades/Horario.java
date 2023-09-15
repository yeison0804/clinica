package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario implements Serializable {

    @Id
    String codigo;
    String dia;
    String hora_inicio;
    String hora_fin;

    @ManyToOne
    @JoinColumn(name="codigo_medico")
    Medico medico;

}
