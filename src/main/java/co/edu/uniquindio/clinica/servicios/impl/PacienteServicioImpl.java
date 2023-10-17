package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import co.edu.uniquindio.clinica.modelo.entidades.Paciente;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.MedicoRepo;
import co.edu.uniquindio.clinica.repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.servicios.PacienteServicio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepo pacienteRepo;
    private final CitaRepo citaRepo;
    private final MedicoRepo medicoRepo;


    @Override
    public int registrarse(PacienteDTO pacienteDTO) throws Exception {


        Paciente paciente = new Paciente();

        paciente.setCorreo(pacienteDTO.correo());
        paciente.setPassword(pacienteDTO.password());
        paciente.setNombre(pacienteDTO.nombre());
        paciente.setCedula(pacienteDTO.cedula());
        paciente.setTelefono(pacienteDTO.telefono());
        paciente.setCodigoCiudad(pacienteDTO.ciudad());
        paciente.setUrl_foto(pacienteDTO.urlFoto());
        paciente.setFecha_nacimiento(pacienteDTO.fechaNacimiento());
        paciente.setCodigoeps(pacienteDTO.eps());
        paciente.setAlergias(pacienteDTO.alergias());
        paciente.setCodigotipo_sangre(pacienteDTO.tipoSangre());


        Paciente pacienteCreado = pacienteRepo.save(paciente);


        return pacienteCreado.getCodigo();
    }

    @Override
    public int editarPerfil(DetallePacienteDTO detallePacienteDTO) throws Exception {

        Optional<Paciente> pacienteBuscado = pacienteRepo.findById(detallePacienteDTO.codigo());

        if (pacienteBuscado.isEmpty()) {
            throw new Exception("No existe un paciente con el código " + detallePacienteDTO.codigo());
        }


        Paciente paciente = pacienteBuscado.get();


        paciente.setCorreo(detallePacienteDTO.correo());
        paciente.setNombre(detallePacienteDTO.nombre());
        paciente.setCedula(detallePacienteDTO.cedula());
        paciente.setTelefono(detallePacienteDTO.telefono());
        paciente.setCodigoCiudad(detallePacienteDTO.ciudad());
        paciente.setUrl_foto(detallePacienteDTO.urlFoto());

        paciente.setFecha_nacimiento(detallePacienteDTO.fechaNacimiento());
        paciente.setCodigoeps(detallePacienteDTO.eps());
        paciente.setAlergias(detallePacienteDTO.alergias());
        paciente.setCodigotipo_sangre(detallePacienteDTO.tipoSangre());
        paciente.setCodigo(detallePacienteDTO.codigo());

        pacienteRepo.save(paciente);

        return paciente.getCodigo();
    }

    @Override
    public void eliminarCuenta(int codigo) throws Exception {

        Optional<Paciente> pacienteBuscado = pacienteRepo.findById(codigo);

        if (pacienteBuscado.isEmpty()) {
            throw new Exception("No existe un paciente con el código " + codigo);
        }


        pacienteRepo.delete(pacienteBuscado.get());


    }

    @Override
    public void enviarLinkRecuperacion() throws Exception {

    }

    @Override
    public void cambiarPassword() throws Exception {

    }

    @Override
    public void agendarCita() throws Exception {

    }

    @Override
    public void crearPQRS() throws Exception {

    }

    @Override
    public void listarPQRSPaciente() throws Exception {

    }

    @Override
    public void responderPQRS() throws Exception {

    }

    @Override
    public void listarCitasPaciente() throws Exception {

    }

    @Override
    public void filtrarCitasPorFecha() throws Exception {

    }

    @Override
    public void filtrarCitasPorMedico(MedicoDTO medicoDTO) throws Exception {

        int codigo = medicoDTO.codigo();

        // Verificar si el médico existe
        Medico medico = medicoRepo.findById(codigo)
                .orElseThrow(() -> new Exception("No se encontró un médico con el ID: " + codigo));

        // Obtener las citas asociadas al médico
        List<Cita> citasDelMedico = citaRepo.findByMedico(medico);

        // Ahora puedes hacer algo con la lista de citas, como imprimir la información
        for (Cita cita : citasDelMedico) {
            System.out.println("Cita para el médico " + medico.getNombre() + ": " + cita.getFecha_cita());
            // Puedes acceder a más campos según tu modelo de datos
        }


    }


    @Override
    public void verDetalleCita() throws Exception {

    }

    @Override
    public List<PacienteDTO> listarTodos() {

        List<Paciente> pacientes = pacienteRepo.findAll();
        List<PacienteDTO> repuesta = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            repuesta.add( new PacienteDTO( paciente.getCedula(),paciente.getNombre(),
                    paciente.getFecha_nacimiento(), paciente.getAlergias(),paciente.getCodigotipo_sangre(),paciente.getCodigoeps(),paciente.getCorreo(),paciente.getPassword(),paciente.getTelefono(),paciente.getCodigoCiudad(),paciente.getUrl_foto()) );
        }


        return repuesta;
    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {

        Optional<Paciente> pacienteBuscado = pacienteRepo.findById(codigo);

        if( pacienteBuscado.isEmpty() ){
            throw new Exception("No existe un paciente con el código "+codigo);
        }

        Paciente paciente = pacienteBuscado.get();



        return new DetallePacienteDTO( paciente.getCodigo(), paciente.getCedula(),
                paciente.getNombre(), paciente.getFecha_nacimiento(), paciente.getAlergias(), paciente.getCodigotipo_sangre(),
                paciente.getCodigoeps(), paciente.getCorreo(), paciente.getPassword(),
                paciente.getTelefono(), paciente.getCodigoCiudad(),paciente.getUrl_foto());

    }


    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCorreo(correo) != null;
    }
}
