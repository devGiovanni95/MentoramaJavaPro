package br.com.sistema.hospitalar.repositories;

import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaudeEntity, Long> {
}
