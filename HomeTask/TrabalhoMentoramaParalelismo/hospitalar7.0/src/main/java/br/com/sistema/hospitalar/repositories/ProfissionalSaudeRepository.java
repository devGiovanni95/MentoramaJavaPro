package br.com.sistema.hospitalar.repositories;

import br.com.sistema.hospitalar.entities.InternacaoEntity;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Async("executorService")
@Repository
public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaudeEntity, Long> {

    @Query(value = "select departamento, count(departamento) " +
            "as quantidade_por_departamento from profissional_saude_entity " +
            " group by departamento order by quantidade_por_departamento desc", nativeQuery = true)
    CompletableFuture<List<ProfissionalSaudeEntity>> findByNumberMedicByDepartament();


    CompletableFuture<Optional<InternacaoEntity>> findOneById(final Long id);

    CompletableFuture<List<InternacaoEntity>> findAllBy();

}
