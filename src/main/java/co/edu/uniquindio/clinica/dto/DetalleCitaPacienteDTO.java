package co.edu.uniquindio.clinica.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record DetalleCitaPacienteDTO(


        String idCita,
        LocalDate fechaCita,
         LocalTime horaCita,
         String nombreMedico,
         String especialidadMedico,
         String motivoConsulta,
         String estadoCita



) {
}
