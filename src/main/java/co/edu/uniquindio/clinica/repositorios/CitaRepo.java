package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepo extends JpaRepository<Cita,String> {


    List<Cita> findByMedico(Medico medico);

}
