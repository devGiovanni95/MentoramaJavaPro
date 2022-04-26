package br.com.sistemahospitalar.repositories;

import br.com.sistemahospitalar.entities.InternacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternacaoRepository extends JpaRepository<InternacaoEntity, Long> {
}
