package br.com.mentorama.productapi.service;

import br.com.mentorama.productapi.model.Order;
import br.com.mentorama.productapi.model.OrderItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderCalculatorTest {
    @Test
    public void shouldCalculateTotalOrderPrice() {
        final OrderCalculator orderCalculator = new OrderCalculator();
        final Order order = new Order(aListOfOrderItems());
        Double result = orderCalculator.calculatorOrder(order);
        assertEquals(30.0, result);
    }

    @Test
    public void shouldCalculateTotalOfMultipleOrders() {
        final OrderCalculator orderCalculator = new OrderCalculator();
        final List<Order> orders =
                Arrays.asList(
                        new Order(aListOfOrderItems()),
                        new Order(aListOfOrderItems())
                );
        final Double result = orderCalculator.calculateMultipleOrders(orders);
        assertEquals(60.0, result);
    }


    private List<OrderItem> aListOfOrderItems() {
        return Arrays.asList(
                aOrderItem(20.0),
                aOrderItem(10.0)
        );
    }

    private OrderItem aOrderItem(final Double expectedValue) {


        OrderItem orderItem = mock(OrderItem.class);
        when(orderItem.totalPrice()).thenReturn(expectedValue);
//        Mockito.verify(orderItem);
        return orderItem;

    }

}