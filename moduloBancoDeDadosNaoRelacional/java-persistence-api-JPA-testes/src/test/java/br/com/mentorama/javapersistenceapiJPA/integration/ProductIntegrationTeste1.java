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
public class ProductIntegrationTeste1 {

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

        productRepository.save(aProductEntity("Description"));
        productRepository.save(aProductEntity("Description"));

        List<ProductEntity> products = productController.findAll();
        Assertions.assertThat(products).hasSize(2);
    }

    @Test
    public void shouldFindByDescription(){
        productRepository.save(aProductEntity("Description"));
        productRepository.save(aProductEntity("Description 2"));
        productRepository.save(aProductEntity("Qualquer coisa"));

        List<ProductEntity> productEntities =
            productController.findByDescription("Descript");

        Assertions.assertThat(productEntities).hasSize(2);

    }
//
//    @Test
//    public void shouldDelete(){
//        productRepository.save(aProductEntity("Description"));
//        productRepository.save(aProductEntity("Description 2"));
//        productRepository.save(aProductEntity("Qualquer coisa"));
//
//         productEntities =
//            productController.delete(1L);
//
//        Assertions.assertThat(productEntities).hasSize(2);
//
//    }

    private ProductEntity aProductEntity(String description) {
        final ProductEntity product = new ProductEntity();
        product.setDescription(description);
        product.setValue(10.0);
        return product;
    }

}
