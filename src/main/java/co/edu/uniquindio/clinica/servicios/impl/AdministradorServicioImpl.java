package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.modelo.entidades.*;
import co.edu.uniquindio.clinica.repositorios.*;
import co.edu.uniquindio.clinica.servicios.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AdministradorServicioImpl implements AdministradorServicio {


    private final MedicoRepo medicoRepo;
    private final PqrsRepo pqrsRepo;
    private final CitaRepo citaRepo;
    private final HorarioRepo horarioRepo;
    private final CuentaRepo cuentaRepo;
    private final MensajeRepo mensajeRepo;


    @Override
    public int crearMedico(MedicoDTO medicoDTO) throws Exception {
        Medico medico = new Medico();
        medico.setCodigo(medicoDTO.codigo());
        medico.setNombre(medicoDTO.nombre());
        medico.setUrl_foto(medicoDTO.urlFoto());
        medico.setEstado(false);
        medico.setCodigoEspecialidad(medicoDTO.codigoEspecialidad());
        medico.setCodigoCiudad(medicoDTO.codigoCiudad());
        medico.setCorreo(medicoDTO.correo());
        medico.setPassword(medicoDTO.password());
        medico.setTelefono(medicoDTO.telefono());


     Medico medicoNuevo=medicoRepo.save(medico);

        return medicoNuevo.getCodigo();
    }

    @Override
    public String actualizarMedico( InfoMedicoDTO infoMedicoDTO) throws Exception {

    Optional<Medico> buscado =medicoRepo.findById(infoMedicoDTO.codigo());

        if(buscado.isEmpty() ){
            throw new Exception("El código "+infoMedicoDTO.codigo()+" no existe");
        }

        Medico medico = buscado.get();
        medico.setCedula(infoMedicoDTO.cedula());
        medico.setNombre(infoMedicoDTO.nombre());
        medico.setUrl_foto(infoMedicoDTO.url());
        medico.setCodigoEspecialidad(infoMedicoDTO.codigoEspecialidad());
        medico.setCodigoCiudad(infoMedicoDTO.codigoCiudad());
        medico.setTelefono(infoMedicoDTO.telefono());
        medico.setCorreo(infoMedicoDTO.correo());


        Medico medicoNuevo=medicoRepo.save(medico);
        return "medico actualizado con exito";
    }

    @Override
    public String eliminarMedico(int codigo) throws Exception {
        Optional<Medico> buscado = medicoRepo.findById(codigo);

        if (buscado.isEmpty()) {

            throw new Exception("el codigo" + codigo + "no existe");

        }
        medicoRepo.delete(buscado.get());
      //  Medico obtenido = buscado.get();
      //  obtenido.setEstado(false);
      //  medicoRepo.save(obtenido);
        return "Se ha eliminado el medico";
    }

    @Override
    public List<MedicoDTOAdmin> listarMedicos() throws Exception {

        List<Medico> medicos = medicoRepo.findAll();
        List<MedicoDTOAdmin> respuesta = new ArrayList<>();

        for (Medico medico:medicos) {


                respuesta.add(new MedicoDTOAdmin(
                         medico.getCodigo(),
                         medico.getNombre(),
                         medico.getUrl_foto(),
                         medico.getCodigoEspecialidad()));


        }


        return respuesta;
    }

    @Override
    public InfoMedicoDTO obtenerMedico(int codigo) throws Exception {

        Optional<Medico> buscado = medicoRepo.findById(codigo);

        if(buscado.isEmpty() ){
            throw new Exception("El código "+codigo+" no existe");
        }

        Medico obtenido = buscado.get();

        InfoMedicoDTO infoMedicoDTO = new InfoMedicoDTO(obtenido.getCodigo(),
                obtenido.getNombre(),
                obtenido.getCedula(),
                obtenido.getCodigoCiudad(),
                obtenido.getCodigoEspecialidad(),
                obtenido.getTelefono(),
                obtenido.getCorreo(),
                new ArrayList<>(),
                obtenido.getUrl_foto());


        return infoMedicoDTO;
    }

    @Override
    public List<PQRSDTOAdmin> listarPQRS() throws Exception {

        List<Pqrs> pqrs1 = pqrsRepo.findAll();
        List<PQRSDTOAdmin> respuesta = new ArrayList<>();

        for (Pqrs pqrs:pqrs1) {

            if(pqrs.isEstadoPqr()){
                respuesta.add(new PQRSDTOAdmin(  pqrs.getCodigo(),
                        pqrs.getEstado(),
                        pqrs.getFecha_creacion(),
                        pqrs.getCita().getPaciente().getNombre()));


            }
        }

        return respuesta;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        Optional<Pqrs> opcionalPQRS = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());

        if(opcionalPQRS.isEmpty()){
            throw new Exception("No existe un PQRS con el código "+registroRespuestaDTO.codigoPQRS());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());
        if(opcionalCuenta.isEmpty()){
            throw new Exception("No existe una cuenta con el código "+registroRespuestaDTO.codigoCuenta());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPqrs(opcionalPQRS.get());
        mensajeNuevo.setFecha_creacion( LocalDateTime.now() );
        mensajeNuevo.setCuenta(opcionalCuenta.get());
        mensajeNuevo.setMensaje(registroRespuestaDTO.mensaje() );

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }


    @Override
    public InfoPQRSDTO verDetallePQRS(String codigo) throws Exception {
        Optional <Pqrs> opcional = pqrsRepo.findById(codigo);

        if(opcional.isEmpty()){
            throw new Exception(("el codigo " + codigo + "no esta asociado a ningun pqrs"));


        }

        Pqrs pqrs = opcional.get();

        return new InfoPQRSDTO(pqrs.getCodigo(),
                pqrs.getCita().getCodigo(),
                pqrs.getMotivo(),
                pqrs.getNombrePaciente(),
                pqrs.getFecha_creacion(),
                new ArrayList<>());



    }

    @Override
    public List<CitaDTOAdmin> listarCitas() throws Exception {

        List<Cita> citas = citaRepo.findAll();
        List<CitaDTOAdmin> respuesta = new ArrayList<>();

        if(citas.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        for( Cita c : citas ){
            respuesta.add( new CitaDTOAdmin(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getCodigoEspecialidad(),
                    c.getEstadoCita(),
                    c.getFecha_cita()
            ) );
        }

        return null;
    }

    @Override
    public void cambiarEstadoPQRS(String codigoPQRS, Estado_PQRS estadoPQRS) throws Exception {

        Optional<Pqrs> opcional = pqrsRepo.findById(codigoPQRS);

        if( opcional.isEmpty() ){
            throw new Exception("No existe un PQRS con el código "+codigoPQRS);
        }


        Pqrs pqrs = opcional.get();
        pqrs.setEstado( estadoPQRS);

        pqrsRepo.save( pqrs );



    }

    @Override
    public InfoMedicoDTO verDetalleMedico(int codigo) throws Exception {

        Optional<Medico> medicoBuscado = medicoRepo.findById(codigo);

        if( medicoBuscado.isEmpty() ){
            throw new Exception("No existe un medico con el código "+codigo);
        }

        Medico medico = medicoBuscado.get();


        return new InfoMedicoDTO(medico.getCodigo(),medico.getNombre(),medico.getCedula(),
                medico.getCodigoCiudad(),medico.getCodigoEspecialidad(),medico.getTelefono(),
                medico.getCorreo(),medico.getHorariosLibres(),medico.getUrl_foto());
    }


    private void AsignarHorariosMedico(Medico medico,List<HorarioDTO>horarios){

        for (HorarioDTO h:horarios) {


            Horario hm = new Horario();
            hm.setDia(h.dia());
            hm.setMedico(medico);
            hm.setHora_fin(h.horaSalida());
            hm.setHora_inicio(h.horaInicio());

            horarioRepo.save(hm);
            }
            
        }




    }

