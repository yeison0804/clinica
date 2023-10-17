package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("medico")
@Setter
@Getter
@NoArgsConstructor
public class Medico extends Usuario implements Serializable {
    @Id
    int codigo;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especialidad codigoEspecialidad;

    @OneToMany(mappedBy="medico")
    private List<Dia_Libre> diaslibres;

    @OneToMany(mappedBy="medico")
    private List<Horario> horariosLibres;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    private boolean estado;

    String cedula;

    public void setId(int codigo) {
        this.codigo = codigo;
    }



}
