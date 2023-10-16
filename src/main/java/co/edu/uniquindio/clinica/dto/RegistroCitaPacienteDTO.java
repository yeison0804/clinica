package co.edu.uniquindio.clinica.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record RegistroCitaPacienteDTO(


        LocalDate fechaCita,
        LocalTime horaCita,
        String idMedico,
        String motivoConsulta,
        String idPaciente,
        String estadoCita,
        String correoPaciente,
        String notasAdicionales

) {
}
