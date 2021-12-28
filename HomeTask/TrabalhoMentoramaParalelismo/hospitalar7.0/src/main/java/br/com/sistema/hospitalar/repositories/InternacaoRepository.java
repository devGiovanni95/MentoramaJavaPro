package br.com.sistema.hospitalar.repositories;

import br.com.sistema.hospitalar.entities.InternacaoEntity;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Async("executorService")
@Repository
public interface InternacaoRepository extends JpaRepository<InternacaoEntity, Long> {

    @Query(value = "select nome_paciente,\n" +
            "count(nome_paciente) as quantidade_internacao\n" +
            "from internacao_entity\n" +
            "group by nome_paciente\n" +
            "order by quantidade_internacao desc;", nativeQuery = true)
    CompletableFuture<List<InternacaoEntity>> findByNumberHospitalizationByPatient();

    CompletableFuture<Optional<InternacaoEntity>> findOneById(final Long id);

    CompletableFuture<List<InternacaoEntity>> findAllBy();
}
