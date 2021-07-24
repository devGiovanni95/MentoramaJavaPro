package br.com.mentorama.javapersistenceapiJPA.controllers;

import br.com.mentorama.javapersistenceapiJPA.entities.DepartmentEntity;
import br.com.mentorama.javapersistenceapiJPA.entities.ProductEntity;
import br.com.mentorama.javapersistenceapiJPA.repositories.DepartmentRepository;
import br.com.mentorama.javapersistenceapiJPA.repositories.ProductRepository;
import br.com.mentorama.javapersistenceapiJPA.vos.DepartmentVO;
import br.com.mentorama.javapersistenceapiJPA.vos.ProductVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;
    private final DepartmentRepository departmentRepository;

    public ProductController(ProductRepository productRepository, DepartmentRepository departmentRepository) {
        this.productRepository = productRepository;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<ProductVO> findAll() {
        return this.productRepository.findAll()
                .stream()
                .map(this::toProductVO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductVO findById(@PathVariable("id") final Long id) {
        return this.productRepository.findById(id)
                .map(this::toProductVO)
                .orElse(null);
    }

    /*informaremos que é um  GET*/

    @GetMapping("/description/{description}")
    public List<ProductVO> findByDescription(@PathVariable("description") final String description) {
        return this.productRepository.findByDescriptionContaining(description)
                .stream()
                .map(this::toProductVO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createNew(@RequestBody final ProductVO product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(product.getDescription());
        productEntity.setValue(product.getValue());
        productEntity.setDepartment(
                departmentRepository.findById(product.getDepartment().getId())
                .orElse(null)
        );
        this.productRepository.save(productEntity);
    }

    @PutMapping
    public void update(@RequestBody final ProductEntity productEntity) {
        this.productRepository.save(productEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        this.productRepository.deleteById(id);
    }

    private ProductVO toProductVO(ProductEntity entity) {
        ProductVO productVO = new ProductVO();
        productVO.setDepartment(toDepartmentVO(entity.getDepartment()));
        productVO.setDescription(entity.getDescription());
        productVO.setId(entity.getId());
        productVO.setValue(entity.getValue());
        return productVO;
    }



    private DepartmentVO toDepartmentVO(DepartmentEntity departmentEntity) {
        DepartmentVO departmentVO = new DepartmentVO();
        departmentVO.setId(departmentVO.getId());
        departmentVO.setName(departmentEntity.getName());
        return departmentVO;
    }


}
