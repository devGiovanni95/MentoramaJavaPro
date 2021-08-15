package br.com.mentorama.javapersistenceapiJPA.integration;

import br.com.mentorama.javapersistenceapiJPA.entity.ProductEntity;
import br.com.mentorama.javapersistenceapiJPA.entity.controllers.ProductController;
import br.com.mentorama.javapersistenceapiJPA.repositories.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductIntegrationTeste {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp(){
        productRepository.deleteAll();
    }

    @Test
    public void shouldFindAll(){

        productRepository.save(aProductEntity());
        productRepository.save(aProductEntity());

        List<ProductEntity> products = productController.findAll();
        Assertions.assertThat(products).hasSize(2);
    }

    @Test
    public void shouldFindByDescription(){
        productRepository.save(aProductEntity());

        List<ProductEntity> productEntities =
            productController.findByDescription("Description");

        Assertions.assertThat(productEntities).hasSize(1);

    }

    private ProductEntity aProductEntity() {
        final ProductEntity product = new ProductEntity();
        product.setDescription("Description");
        product.setValue(10.0);
        return product;
    }

}
