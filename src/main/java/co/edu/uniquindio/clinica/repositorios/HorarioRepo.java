package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepo extends JpaRepository<Horario,String> {
}
