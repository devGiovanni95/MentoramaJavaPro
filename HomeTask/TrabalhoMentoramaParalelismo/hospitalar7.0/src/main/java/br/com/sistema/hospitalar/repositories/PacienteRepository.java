package br.com.sistema.hospitalar.repositories;

import br.com.sistema.hospitalar.entities.InternacaoEntity;
import br.com.sistema.hospitalar.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Async("executorService")
@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {


    CompletableFuture<Optional<InternacaoEntity>> findOneById(final Long id);

    CompletableFuture<List<InternacaoEntity>> findAllBy();

}
