package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record CitaDTOMedico(

        int codigoCita,
        String nombrePaciente,
        LocalDateTime fecha,
        String motivo,
        String diagnostico,
        String tratamiento



) {
}
