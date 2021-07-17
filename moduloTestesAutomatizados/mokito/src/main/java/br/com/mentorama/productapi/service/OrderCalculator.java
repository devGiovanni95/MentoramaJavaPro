package br.com.mentorama.productapi.service;

import br.com.mentorama.productapi.model.Order;
import br.com.mentorama.productapi.model.OrderItem;

import java.util.List;

public class OrderCalculator {

    /*Refatoramos a classe e o tipo de parametro passado*/
    public Double calculatorOrder(final Order order){
        return order.getItems().stream().mapToDouble(OrderItem::totalPrice)
                .sum();
    }


    /*Depois de term os criado o teste de antemao para testar a aplicacao desenvolvemos e implementamos
    * toda a logica emcima de um metodo que criamos na fase da crtiacao de testen
    * um dos modos mais faceis e implementando de uma maneira parecida com o que ja implementamos de ante ma
    * desenvolvendo um codigo mais simples possivel fazendo com que oi nosso teste passe sem problemas */

                                                /*c riamos uma lista de listas de orderItem */

    /*Codigo refatorado */
    public Double calculateMultipleOrders(final List<Order> orders) {
        return orders.stream().mapToDouble(order -> calculatorOrder(order)).sum();
    }
}
