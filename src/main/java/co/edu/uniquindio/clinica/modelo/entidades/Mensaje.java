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
public class Mensaje implements Serializable {


    @Id
    String codigo;
    String fecha_creacion;
    String mensaje;

    @ManyToOne
    @JoinColumn(name="Codigo_pqrs")
    Pqrs pqrs;

    @ManyToOne
    @JoinColumn(name="Codigo_cuenta")
    Cuenta cuenta;

    @OneToOne
    @JoinColumn(name="Codigo_mensaje")
    Mensaje mensajeNuevo;

}
