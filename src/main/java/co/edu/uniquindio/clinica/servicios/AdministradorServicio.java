package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.modelo.entidades.Estado_PQRS;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medico) throws Exception;

    String actualizarMedico(InfoMedicoDTO infoMedicoDTO) throws Exception;

    String eliminarMedico(int codigo) throws Exception;

    List<MedicoDTOAdmin> listarMedicos() throws Exception;

    InfoMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<PQRSDTOAdmin> listarPQRS() throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    InfoPQRSDTO verDetallePQRS(String codigo) throws Exception;

    List<CitaDTOAdmin> listarCitas() throws Exception;

    void cambiarEstadoPQRS(String codigoPQRS, Estado_PQRS estadoPQRS) throws Exception;
    InfoMedicoDTO verDetalleMedico(int codigo)throws Exception;




}
