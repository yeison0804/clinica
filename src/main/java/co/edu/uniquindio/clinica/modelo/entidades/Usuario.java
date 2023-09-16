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
   @Column(nullable = false)
    String nombre;
   @Column(nullable = false)
    String telefono;
   @Column(nullable = false)
    String url_foto;
    @Enumerated(EnumType.STRING)
    private Ciudad codigoCiudad;


}
