package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.nio.MappedByteBuffer;

@Entity
public class Cita implements Serializable {
    @Id
    String codigo;
    String fecha_creacion;
    String fecha_cita;
    String motivo;

    @ManyToOne
    @JoinColumn(name="Codigo_medico")
    Medico medico;

    @ManyToOne
    @JoinColumn(name="Cedula_paciente")
    Paciente paciente;

   @Enumerated(EnumType.STRING)
   private Estado_Cita estadoCita;

}
