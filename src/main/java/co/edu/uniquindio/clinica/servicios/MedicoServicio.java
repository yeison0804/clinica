package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.CitaDTOMedico;
import co.edu.uniquindio.clinica.dto.MedicoDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;

import java.util.Date;
import java.util.List;

public interface MedicoServicio {


    List<Cita>  listarCitasPendientes(MedicoDTO medicoDTO);

    void atenderCita(CitaDTOMedico citaDTOMedico);

    List<Cita> listarCitasPaciente(PacienteDTO pacienteDTO); //historial médico

    List<Date> agendarDiaLibre();

    List<Cita> listarCitasRealizadasMedico(MedicoDTO medicoDTO);




}
