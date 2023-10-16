package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Estado_PQRS;

import java.time.LocalDateTime;
import java.util.Date;

public record PQRSDTOAdmin(String codigo, Estado_PQRS estado, Date fecha, String nombrePaciente) {
}
