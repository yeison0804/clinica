package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.entidades.Horario;

import java.util.List;

public record InfoMedicoDTO(


        int codigo,
        String nombre,
        String cedula,
        Ciudad codigoCiudad,
        Especialidad codigoEspecialidad,
        String telefono,
        String correo,
        List<Horario> horarios,
        String url


) {

}
