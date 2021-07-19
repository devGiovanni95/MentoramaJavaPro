package br.com.mentorama.vendas.service;

import br.com.mentorama.vendas.model.ListOfProductInStock;
import br.com.mentorama.vendas.model.OrderSale;

public class OrderSaleCalculate {

    public Double calculeOrder(final ListOfProductInStock listOfProductInStock){
        return listOfProductInStock.getStockRegister().stream().mapToDouble(OrderSale::getTotalPriceSale).sum();
    }

}
