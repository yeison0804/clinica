package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje implements Serializable {


    @Id
    int codigo;
    @Column(nullable = false)
    LocalDateTime fecha_creacion;
    @Column(nullable = false)
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
