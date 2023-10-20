package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.InfoPQRSDTO;
import co.edu.uniquindio.clinica.dto.PqrDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Paciente;
import co.edu.uniquindio.clinica.modelo.entidades.Pqrs;
import co.edu.uniquindio.clinica.repositorios.PqrsRepo;
import co.edu.uniquindio.clinica.servicios.PqrsServicio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PqrsServicioImpl implements PqrsServicio {


    private final PqrsRepo pqrsRepo;


    @Override
    public String crearPQR(PqrDTO pqrDTO) throws Exception {

        Pqrs pqrs = new Pqrs();

        pqrs.setCodigo(pqrDTO.codigo());
        pqrs.setEstado(pqrDTO.estado());
        pqrs.setCita(pqrDTO.codigoCita());
        pqrs.setMotivo(pqrDTO.motivo());
        pqrs.setNombrePaciente(pqrDTO.nombrePaciente());
        pqrs.setFecha_creacion(pqrDTO.fecha());
        pqrs.setMensajes(pqrDTO.mensajes());

        Pqrs pqrsCreado = pqrsRepo.save(pqrs);

        return pqrsCreado.getCodigo();
    }

    @Override
    public String actualizarPQR(PqrDTO pqrDTO) throws Exception {

        Optional<Pqrs> pqrBuscado = pqrsRepo.findById(pqrDTO.codigo());

        if (pqrBuscado.isEmpty()) {
            throw new Exception("No existe un pqrs asociado al código " + pqrDTO.codigo());
        }

    Pqrs pqrs =pqrBuscado.get();

        pqrs.setCodigo(pqrDTO.codigo());
        pqrs.setEstado(pqrDTO.estado());
        pqrs.setCita(pqrDTO.codigoCita());
        pqrs.setMotivo(pqrDTO.motivo());
        pqrs.setNombrePaciente(pqrDTO.nombrePaciente());
        pqrs.setFecha_creacion(pqrDTO.fecha());
        pqrs.setMensajes(pqrDTO.mensajes());

        pqrsRepo.save(pqrs);


        return pqrs.getCodigo();
    }

    @Override
    public String eliminarPQR(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<PqrDTO> listarPQR() throws Exception {
        return null;
    }

    @Override
    public InfoPQRSDTO verDetallePQR(int codigo) throws Exception {
        return null;
    }
}
