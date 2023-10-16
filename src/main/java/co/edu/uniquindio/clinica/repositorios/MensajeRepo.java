package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepo extends JpaRepository<Mensaje,String> {
}
