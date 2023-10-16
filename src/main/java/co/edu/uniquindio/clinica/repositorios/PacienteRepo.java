package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepo extends JpaRepository<Paciente,Integer> {

    Paciente findByCedula(String cedula);
    Paciente findByCorreo(String correo);
}
