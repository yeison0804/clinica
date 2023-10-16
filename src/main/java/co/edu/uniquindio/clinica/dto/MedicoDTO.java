package co.edu.uniquindio.clinica.dto;
import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.entidades.Especialidad;

import java.util.List;

public record MedicoDTO(
        String nombre,
        int codigo,
        Ciudad codigoCiudad,
        Especialidad codigoEspecialidad,

        String telefono,
        String correo,
        String password,
        List< HorarioDTO > horarios,
        String urlFoto,
        boolean estado


) {



}
