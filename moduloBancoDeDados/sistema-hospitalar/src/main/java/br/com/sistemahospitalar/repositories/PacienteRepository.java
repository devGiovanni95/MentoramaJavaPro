package br.com.sistemahospitalar.repositories;

import br.com.sistemahospitalar.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

}
