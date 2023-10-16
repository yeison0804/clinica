package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.entidades.Estado_Cita;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CitaDTOAdmin(

        String codigoCita,
        String cedulaPaciente,
        String nombrePaciente,
        String nombreMedico,
        Especialidad especialidad,
        Estado_Cita estadoCita,
        LocalDate fecha
) {
}
