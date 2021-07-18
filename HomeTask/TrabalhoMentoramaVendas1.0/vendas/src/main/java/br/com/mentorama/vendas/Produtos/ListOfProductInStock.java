package br.com.mentorama.vendas.Produtos;

import java.util.Arrays;
import java.util.List;

public class ListOfProductInStock {

    private Integer id;
    private String productName;
    private Integer quantityInStock;
    private Double price;
    private Double discountMaxPercentage;


//    Product produto1 = new Product(1, "Celular", 20, 1099.99, 0.1);
//    Product produto2 = new Product(2, "TV 32'", 5, 1500.00, 0.15);
//    Product produto3 = new Product(3, "Monitor", 3, 700.99, 0.1);
//    Product produto4 = new Product(4, "Notebook", 10, 1590.00, 0.12);
//    Product produto5 = new Product(5, "Violão", 25, 2500.00, 0.20);
//    Product produto6 = new Product(6, "Som Automotivo", 15, 500.00, 0.05);


    private final List<Product> stockRegister;

    public ListOfProductInStock(Object stockRegister) {
        this.stockRegister = Arrays.asList(
                new Product(1, "Celular", 20, 1099.99, 0.1),
                new Product(2, "TV 32'", 5, 1500.00, 0.15),
                new Product(3, "Monitor", 3, 700.99, 0.1),
                new Product(4, "Notebook", 10, 1590.00, 0.12),
                new Product(5, "Violão", 25, 2500.00, 0.20),
                new Product(6, "Som Automotivo", 15, 500.00, 0.05)
        );

//
//        stockRegister.add(produto1);
//        stockRegister.add(produto2);
//        stockRegister.add(produto3);
//        stockRegister.add(produto4);
//        stockRegister.add(produto5);
//        stockRegister.add(produto6);
    }

    public void listar(){
        for (Product lista: stockRegister){
            System.out.println(lista);
        }

    }


    public List<Product> getStockRegister() {
        return stockRegister;
    }

  }
