package co.edu.uniquindio.clinica.modelo.entidades;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@DiscriminatorValue("admin")
public class Administrador extends Cuenta implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

}
