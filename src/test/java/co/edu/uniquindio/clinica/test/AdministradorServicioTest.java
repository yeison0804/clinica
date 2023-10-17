package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.HorarioDTO;
import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.entidades.Estado_Cita;
import co.edu.uniquindio.clinica.servicios.AdministradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest


public class AdministradorServicioTest {

   @Autowired
    private AdministradorServicio administradorServicio;


@Test
//@Sql("classpath:datasetAdmin.sql")
    public void crearMedicoTest()throws  Exception{


    // Supongamos que HorarioDTO tiene un constructor que acepta los datos necesarios
    HorarioDTO horario1 = new HorarioDTO("04", "5:00", "8:00");
    HorarioDTO horario2 = new HorarioDTO("05", "9:00", "12:00");

    // Crear la lista de horarios y añadir los horarios
    List<HorarioDTO> horarios = new ArrayList<>();
    horarios.add(horario1);
    horarios.add(horario2);

    MedicoDTO medicoDTO = new MedicoDTO(
            "andres", 7, Ciudad.CALI, Especialidad.ESPECIALIDAD_2,
            "23344455","juan@uniquindio","67777",horarios,"45555555",
            Estado_Cita.PENDIENTE


    );

    int nuevo = administradorServicio.crearMedico(medicoDTO);
    Assertions.assertNotEquals(0, nuevo);


}



}
