package br.com.mentorama.vendas.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class OrderSaleTest {

    @Test
    public void ShoudCalculateTotalPrice(){
        Product product = new Product(1, "Celular", 2, 500.00, 0.05);

        OrderSale orderSale = new OrderSale(product,3,.10 );
        Double result = orderSale.getTotalPriceSale();

        assertEquals(950.00, result);
    }

}