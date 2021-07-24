package br.com.sistemahospitalar.repositories;

import br.com.sistemahospitalar.entities.ProfissionalSaudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaudeEntity, Long> {
}
