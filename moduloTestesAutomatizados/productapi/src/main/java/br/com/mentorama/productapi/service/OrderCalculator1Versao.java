package br.com.mentorama.productapi.service;

import br.com.mentorama.productapi.model.OrderItem;

import java.util.List;

public class OrderCalculator1Versao {

    public Double calculatorOrder(final List<OrderItem> items){
        return items.stream().mapToDouble(OrderItem::totalPrice)
                .sum();
    }


    /*Depois de term os criado o teste de antemao para testar a aplicacao desenvolvemos e implementamos
    * toda a logica emcima de um metodo que criamos na fase da crtiacao de testen
    * um dos modos mais faceis e implementando de uma maneira parecida com o que ja implementamos de ante ma
    * desenvolvendo um codigo mais simples possivel fazendo com que oi nosso teste passe sem problemas */

                                                /*c riamos uma lista de listas de orderItem */
    public Double calculateMultipleOrders(final List<List<OrderItem>> orders) {
        return orders.stream().mapToDouble(this::calculatorOrder).sum();
    }
}
