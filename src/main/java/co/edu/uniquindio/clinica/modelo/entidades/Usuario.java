package co.edu.uniquindio.clinica.modelo.entidades;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_user", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("usuario")
public class Usuario extends Cuenta implements Serializable {

   @Id
    int codigo;
    String nombre;
    String telefono;
    String url_foto;
    @Enumerated(EnumType.STRING)
    private Ciudad codigoCiudad;


}
