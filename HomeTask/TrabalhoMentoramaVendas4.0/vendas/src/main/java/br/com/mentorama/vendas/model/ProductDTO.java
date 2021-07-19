package br.com.mentorama.vendas.model;

import java.util.List;

public class ProductDTO {
    private List<Product> products;

    public ProductDTO(List<Product> productList){
        this.products = productList;
    }

    public ProductDTO(){

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
