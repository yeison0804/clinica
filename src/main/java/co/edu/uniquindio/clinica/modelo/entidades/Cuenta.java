package co.edu.uniquindio.clinica.modelo.entidades;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_usuario", discriminatorType = DiscriminatorType.STRING)
public class Cuenta implements Serializable {

    @Id
    private int codigo;
    private String correo;
    private String password;

    @OneToMany(mappedBy = "cuenta")
    private List<Mensaje> mensajes;


}
