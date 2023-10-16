package co.edu.uniquindio.clinica.dto;

import java.time.LocalDate;

public record FiltroBusquedaPacienteDTO(

         String nombre,
         String identificacion,
         LocalDate fechaNacimiento,
         String alergias,
         String eps,
         String tipoSangre,
         String ciudadResidencia

) {
}
