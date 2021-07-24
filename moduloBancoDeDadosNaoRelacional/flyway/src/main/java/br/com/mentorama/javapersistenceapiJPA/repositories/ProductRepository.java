package br.com.mentorama.javapersistenceapiJPA.repositories;

import br.com.mentorama.javapersistenceapiJPA.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByDescriptionContaining(String description);

}
