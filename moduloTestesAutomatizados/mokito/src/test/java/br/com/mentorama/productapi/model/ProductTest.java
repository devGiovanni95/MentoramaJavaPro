package br.com.mentorama.productapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test   /*  deve calcular o preço total com desconto */
    public void shouldCalculateTotalPriceWithDiscount() {
        Product product = new Product(1l, "Texto", 100.0, 0.10);
        Double result = product.getPriceWithDiscount(0.10);
        assertEquals(90.0, result);
    }

    @Test   /* quando o desconto é maior do que o desconto máximo deve usar a porcentagem máxima de desconto*/
    public void whenDiscountIsHigherThenMaxDiscountShouldUseMaxDiscountPorcentage() {
        Product product = new Product(1l, "Texto", 100.0, 0.10);
        Double result = product.getPriceWithDiscount(0.15);
        assertEquals(90.0, result);
    }


    @Test   /* quando o desconto é maior do que o desconto máximo deve usar a porcentagem máxima de desconto*/
    public void whenDiscountIsLowerThenMaxDiscountShouldUseProvidedDiscount() {
        Product product = new Product(1l, "Texto", 100.0, 0.10);
        Double result = product.getPriceWithDiscount(0.05);
        assertEquals(95.0, result);
    }


}
