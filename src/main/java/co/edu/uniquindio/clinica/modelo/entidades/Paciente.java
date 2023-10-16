package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @Column(nullable =false)
    LocalDate fecha_nacimiento;
    @Column(nullable = false,length = 600)
    String alergias;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo_Sangre Codigotipo_sangre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EPS Codigoeps;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

    String cedula;

}
