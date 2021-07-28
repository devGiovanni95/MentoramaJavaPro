package br.com.sistema.hospitalar.repositories;

import br.com.sistema.hospitalar.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

}
