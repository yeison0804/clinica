package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepo extends JpaRepository<Cuenta,Integer> {
}
