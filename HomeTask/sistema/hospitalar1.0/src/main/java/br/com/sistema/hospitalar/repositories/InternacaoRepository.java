package br.com.sistema.hospitalar.repositories;

import br.com.sistema.hospitalar.entities.InternacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternacaoRepository extends JpaRepository<InternacaoEntity, Long> {
}
