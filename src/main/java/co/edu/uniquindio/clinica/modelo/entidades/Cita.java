package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.nio.MappedByteBuffer;

@Entity
public class Cita implements Serializable {
    @Id
    String codigo;
    @Column(nullable = false)
    String fecha_creacion;
    @Column(nullable = false)
    String fecha_cita;
    @Column(nullable = false)
    String motivo;

    @ManyToOne
    @JoinColumn(name="Codigo_medico")
    Medico medico;

    @ManyToOne
    @JoinColumn(name="Cedula_paciente")
    Paciente paciente;

    @OneToOne(mappedBy = "cita")
    Atencion atencion;

   @Enumerated(EnumType.STRING)
   private Estado_Cita estadoCita;

}
