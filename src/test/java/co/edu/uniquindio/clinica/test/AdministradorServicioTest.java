package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.entidades.Estado_Cita;
import co.edu.uniquindio.clinica.servicios.AdministradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
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


    MedicoDTO medicoDTO2 = new MedicoDTO(
            "sara", 8, Ciudad.CALI, Especialidad.ESPECIALIDAD_2,
            "23344455","juan@uniquindio","67777",horarios,"45555555",
            Estado_Cita.PENDIENTE


    );


    int nuevo = administradorServicio.crearMedico(medicoDTO);
    Assertions.assertNotEquals(0, nuevo);

    int nuevo2 = administradorServicio.crearMedico(medicoDTO2);
    Assertions.assertNotEquals(0, nuevo2);


}

    @Test
     @Sql("classpath:datasetAdmin.sql" )
    public void actualizarMedicoTest() throws Exception{

        InfoMedicoDTO guardado = administradorServicio.verDetalleMedico(15);
        InfoMedicoDTO modificado = new InfoMedicoDTO(
                guardado.codigo(),
                guardado.nombre(),
                guardado.cedula(),
                guardado.codigoCiudad(),
                guardado.codigoEspecialidad(),
                guardado.telefono(),
                guardado.correo(),
                guardado.horarios(),
                guardado.url());


        administradorServicio.actualizarMedico(modificado);

        InfoMedicoDTO objetoModificado = administradorServicio.verDetalleMedico(15);
        Assertions.assertEquals("23344455", objetoModificado.telefono());
    }


    @Test
    //@Sql("classpath:datasetAdmin.sql" )
    public void eliminarMedicoTest() throws Exception{

        administradorServicio.eliminarMedico(15);
        Assertions.assertThrows(Exception.class, () -> administradorServicio.verDetalleMedico(1));
    }

    @Test
    //@Sql("classpath:datasetAdmin.sql" )
    public void listarMedicosTest()throws Exception{
        List<MedicoDTOAdmin> lista = administradorServicio.listarMedicos();
        lista.forEach(System.out::println);
        Assertions.assertEquals(2, lista.size());
    }

}
