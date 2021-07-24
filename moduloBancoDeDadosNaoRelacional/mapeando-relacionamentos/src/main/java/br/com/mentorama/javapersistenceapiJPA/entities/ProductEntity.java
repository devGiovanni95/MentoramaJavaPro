package br.com.mentorama.javapersistenceapiJPA.entities;


import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity  {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(nullable = false)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private ProductEntity department;



    public ProductEntity(){

    }

    public ProductEntity(Long id, String description, Double value) {
        this.id = id;
        this.description = description;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ProductEntity getDepartment() {
        return department;
    }

    public void setDepartment(ProductEntity department) {
        this.department = department;
    }

}
