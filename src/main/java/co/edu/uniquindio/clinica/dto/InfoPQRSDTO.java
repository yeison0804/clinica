package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Estado_PQRS;
import co.edu.uniquindio.clinica.modelo.entidades.Mensaje;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record InfoPQRSDTO(


        String codigo,

        String codigoCita,
        String motivo,
        String nombrePaciente,
        Date fecha,
        List<Mensaje> mensajes
) {



}
