package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.*;

import java.util.List;

public interface PqrsServicio {


    String crearPQR(PqrDTO pqrDTO) throws Exception;

    String actualizarPQR(PqrDTO pqrDTO) throws Exception;

    String eliminarPQR(int codigo) throws Exception;

    List<PqrDTO> listarPQR() throws Exception;

    InfoPQRSDTO verDetallePQR(int codigo)throws Exception;

}
