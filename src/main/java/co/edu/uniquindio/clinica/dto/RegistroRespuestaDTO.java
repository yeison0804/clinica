package co.edu.uniquindio.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;



public record RegistroRespuestaDTO(


        @Positive
        int codigoCuenta,
        @Positive
        String codigoPQRS,
        @Positive
        int codigoMensaje,
        @NotBlank
        String mensaje

) {
}
