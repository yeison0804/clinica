package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Pqrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PqrsRepo extends JpaRepository<Pqrs,String> {






}
