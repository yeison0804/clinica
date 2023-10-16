package co.edu.uniquindio.clinica.test;
import co.edu.uniquindio.clinica.dto.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.entidades.EPS;
import co.edu.uniquindio.clinica.modelo.entidades.Tipo_Sangre;
import co.edu.uniquindio.clinica.servicios.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest

public class PacienteServicioTest {

    @Autowired
    private PacienteServicio pacienteServicio;



    @Test
  //  @Sql("classpath:dataset.sql" )
    public void registrarTest() throws Exception{
        //Creamos un objeto con los datos del paciente
        PacienteDTO pacienteDTO = new PacienteDTO(
                "1097222222",

                "juan andres",
                LocalDate.of(2000,9,5),
                "fiebre",
                Tipo_Sangre.A_POSITIVO,
                EPS.EPS_3,
                "juan@jgjjg",
                "45556",
                "111111",
                Ciudad.BOGOTA,
                "lllllllllll");


        PacienteDTO pacienteDTO2 = new PacienteDTO(
                "10666666666",

                "yeison marin",
                LocalDate.of(2000,8,4),
                "fiebre",
                Tipo_Sangre.A_POSITIVO,
                EPS.EPS_3,
                "juan@jgjjg",
                "45556",
                "111111",
                Ciudad.BOGOTA,
                "xxxxxxxx");


        //Guardamos el registro usando el método del servicio
        int nuevo = pacienteServicio.registrarse(pacienteDTO);
        int nuevo2 = pacienteServicio.registrarse(pacienteDTO2);

        Assertions.assertNotEquals(0, nuevo);
        Assertions.assertNotEquals(0, nuevo2);
    }


    @Test
   // @Sql("classpath:dataset.sql" )
    public void actualizarTest() throws Exception{

        DetallePacienteDTO guardado = pacienteServicio.verDetallePaciente(8);
        DetallePacienteDTO modificado = new DetallePacienteDTO(
                guardado.codigo(),
                guardado.cedula(),
                guardado.nombre(),
                LocalDate.of(2000,3,4),
                guardado.alergias(),
                guardado.tipoSangre(),
                guardado.eps(),
                guardado.correo(),
                guardado.password(),
                guardado.telefono(),
                guardado.ciudad(),
                guardado.urlFoto());




        pacienteServicio.editarPerfil(modificado);

        DetallePacienteDTO objetoModificado = pacienteServicio.verDetallePaciente(9);
        Assertions.assertEquals("111111", objetoModificado.telefono());
    }

    @Test
   // @Sql("classpath:dataset.sql" )
    public void eliminarTest() throws Exception{

        pacienteServicio.eliminarCuenta(9);
        Assertions.assertThrows(Exception.class, () -> pacienteServicio.verDetallePaciente(1));
    }


    @Test
    @Sql("classpath:dataset.sql" )
    public void listarTest(){
        List<PacienteDTO> lista = pacienteServicio.listarTodos();
        lista.forEach(System.out::println);
        Assertions.assertEquals(2, lista.size());
    }

}