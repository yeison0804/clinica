package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Paciente;

import java.util.List;

public interface PacienteServicio {

    int registrarse(PacienteDTO pacienteDTO)throws Exception;

    int editarPerfil(DetallePacienteDTO detallePacienteDTO)throws Exception;


    void eliminarCuenta(int codigo)throws Exception;

    void enviarLinkRecuperacion()throws Exception;

    void cambiarPassword()throws Exception;

    void agendarCita()throws Exception;

    void crearPQRS()throws Exception;

    void listarPQRSPaciente()throws Exception;

    void responderPQRS()throws Exception;

    void listarCitasPaciente()throws Exception;

    void filtrarCitasPorFecha()throws Exception;

    void filtrarCitasPorMedico(MedicoDTO medicoDTO)throws Exception;

    void verDetalleCita()throws Exception;

    List<PacienteDTO> listarTodos();

    DetallePacienteDTO verDetallePaciente(int codigo)throws Exception;



}
