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
public class Pqrs implements Serializable {
    @Id
    String codigo;
    String fecha_creacion;
    String tipo;
    String motivo;
    @ManyToOne
    @JoinColumn(name="Codigo_cita")
    Cita cita;

    @OneToMany(mappedBy = "pqrs")
    private List<Mensaje> mensajes;

    @Enumerated(EnumType.STRING)
    private Estado_PQRS codigo_estado;

}
