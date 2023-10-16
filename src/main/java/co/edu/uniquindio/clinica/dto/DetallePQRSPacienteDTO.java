package co.edu.uniquindio.clinica.dto;

import java.time.LocalDate;

public record DetallePQRSPacienteDTO(

         String numeroRadicado,
         LocalDate fechaCreacion,
         String detallePQRS,
         String estadoPQRS,
         String respuestaAdministrador



) {
}
