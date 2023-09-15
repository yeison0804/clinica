package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@DiscriminatorValue("paciente")
public class Paciente  extends Usuario implements Serializable{
    @Id
    int codigo;
    @Column(nullable =false)
    Date fecha_nacimiento;
    String alergias;

    @Enumerated(EnumType.STRING)
    private Tipo_Sangre Codigotipo_sangre;

    @Enumerated(EnumType.STRING)
    private EPS Codigoeps;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;



}
