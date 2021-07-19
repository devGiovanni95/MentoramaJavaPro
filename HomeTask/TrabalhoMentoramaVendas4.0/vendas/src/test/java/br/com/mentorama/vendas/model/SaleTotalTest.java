package br.com.mentorama.vendas.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaleTotalTest {
    /*Calcular valor total da venda*/
    @Test
    public void calculateTotalSaleAmount() {
        SaleTotal saleTotal = new SaleTotal();
        Product product1 = new Product(1, "Celular", 20, 1099.99, 0.1);
        Product product2 = new Product(2, "TV 32'", 5, 1500.00, 0.15);
        Product product3 = new Product(3, "Monitor", 3, 700.99, 0.1);
        Double valor1 = saleTotal.saleTotalPriceProduct(product1, .15, 28);
//        assertEquals(valor1, 19799.8);
        assertEquals(valor1, 19799.82);
        Double valor2 = saleTotal.saleTotalPriceProduct(product2, .16, 6);
//        assertEquals(valor2, 6375.2);
        assertEquals(valor2, 6375.0);
        Double valor3 = saleTotal.saleTotalPriceProduct(product3, .08, 2);
//        assertEquals(valor3, 1289.82);
        assertEquals(valor3, 1289.8216);
        System.out.print(valor1 + valor2 + valor3);

       Double priceFinalTotalSale = saleTotal.saleTotalPrice(valor1,valor2, valor3);
       assertEquals(priceFinalTotalSale, 27464.6416);
//       assertEquals(priceFinalTotalSale, 27464.646);
    }


}