package br.com.mentorama.javapersistenceapiJPA.repositories;

import br.com.mentorama.javapersistenceapiJPA.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByDescriptionContaining(String description);

}
