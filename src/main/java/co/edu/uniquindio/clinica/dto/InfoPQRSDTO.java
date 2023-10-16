package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Estado_PQRS;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record InfoPQRSDTO(


        String codigo,
        Estado_PQRS estado,
        String codigoCita,
        String motivo,
        String nombrePaciente,
        Date fecha,
        List<String> mensajes
) {



}
