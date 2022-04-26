package br.com.mentorama.productapi.service;

import br.com.mentorama.productapi.model.Order;
import br.com.mentorama.productapi.model.OrderItem;
import br.com.mentorama.productapi.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorTest {
// /*Primeira onda de testes*/
//    @Test
//    public void shouldCalculateOrderPrice(){
//        final OrderCalculator orderCalculator = new OrderCalculator();
//        final List<OrderItem> orderItems = Arrays.asList(
//                aOrderItem(2,0.0,10.0, 0.10),/*Vamos refatorar essa lista para podermos utilizar em outros testes*/
//                aOrderItem(10,0.0,1.0, 0.10)
//        );
//        Double result = orderCalculator.calculatorOrder(orderItems);
//        assertEquals(30.0,result);
//
//    }
//
//    private  OrderItem aOrderItem(final Integer quantity,
//                                  final Double discount,
//                                  final Double price,
//                                  final Double maxDiscountPercentage){
//        Product product = new Product(1l, "Teste", price, maxDiscountPercentage);
//        return new OrderItem(product, quantity, discount);
//    }
//
//
    @Test
    public void shouldCalculateOrderPrice(){
        final OrderCalculator orderCalculator = new OrderCalculator();
        final Order order =new Order(aListOfOrderItems());
        Double result = orderCalculator.calculatorOrder(order);
        assertEquals(30.0,result);

    }

/*Refatoramos a criacao da lista para que gerasse uma metodo get para
podermos reutilizarmos ele na criacao de novos testes*/
    private List<OrderItem> aListOfOrderItems() {
        return Arrays.asList(
                aOrderItem(2, 0.0, 10.0, 0.10),
                aOrderItem(10, 0.0, 1.0, 0.10)
        );
    }

    private  OrderItem aOrderItem(final Integer quantity,
                                  final Double discount,
                                  final Double price,
                                  final Double maxDiscountPercentage){
        Product product = new Product(1l, "Teste", price, maxDiscountPercentage);
        return new OrderItem(product, quantity, discount);
    }

    /*Primeiro criamos uma classe de teste que va da erro, para depois disso depois de
    criarmos o teste possamos criar as classes e metodos para que este nosso teste possa
     passar e que funcione da maneira correta pelo teste Junit
     lembrando que devemos implementar de uma forma mais simples possivel para que nao
      quebre a nossa aplicação */
    @Test
    public  void shouldCalculateTotalOfMultipleOrders(){
        final OrderCalculator orderCalculator = new OrderCalculator();
        final List<Order> orders =
                Arrays.asList(
                        new Order (aListOfOrderItems()),
                        new Order(aListOfOrderItems())
                );
        final Double result = orderCalculator.calculateMultipleOrders(orders);
        assertEquals(60.0, result);
    }
    /*Depois de criarmos o codigo e testarmos ele pra ver se realmente funciona aplicamos o
     3 passo do TDD e refatoramos ele de uma maneira mais completa e funcional*/
}