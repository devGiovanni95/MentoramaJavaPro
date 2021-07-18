package br.com.mentorama.vendas.Produtos;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ProductTest1 {

    private Object ListOfProductInStock;


    @Test
    public void shouldCalculateTotalPriceWithDiscount() {
        Product product = new Product(1, "Celular", 2, 500.00, 0.05);
        Double result = product.getPriceWithDiscount(0.15);
        assertEquals(475.0, result);
    }

    @Test
    public void shouldCalculateTotalPriceWithDiscount1() {
        Product product = new Product(1, "Celular", 2, 500.00, 0.05);
        Double result = product.getPriceWithDiscount(0.05);
        assertEquals(475.0, result);
    }

    @Test
    public void shouldCalcuteStock() {

        Product product = new Product(1, "Celular", 2, 500.00, 0.05);
//        OrderSale orderSale = new OrderSale(product, 3, 0.10);
        Integer result = product.getQuantityOfProductFromSale(3);
        assertEquals(2, result);

    }

    @Test
    public void shouldCalcuteStock1() {

        Product product = new Product(1, "Celular", 2, 500.00, 0.05);
//        OrderSale orderSale = new OrderSale(product, 3, 0.10);
        Integer result = product.getQuantityOfProductFromSale(2);
        assertEquals(2, result);

    }

    private OrderSale orderSale(final Double expectedValue){
        OrderSale orderSale = mock(OrderSale.class);
        Mockito.when(orderSale.getTotalPriceSale()).thenReturn(expectedValue);
        return orderSale;

    }

    @Test
    public OrderSale orderSale1(final Double expectedValue){
        ListOfProductInStock orderSale = mock(ListOfProductInStock.class);
        Mockito.when(orderSale.getStockRegister());
        System.out.println(ListOfProductInStock);
        return (OrderSale) ListOfProductInStock;
    }

}