package br.com.mentorama.vendas.service;

import br.com.mentorama.vendas.Produtos.ListOfProductInStock;
import br.com.mentorama.vendas.Produtos.OrderSale;
import br.com.mentorama.vendas.Produtos.Product;
import br.com.mentorama.vendas.Produtos.SaleTotal;

public class OrderSaleCalculate {

    public Double calculeOrder(final ListOfProductInStock listOfProductInStock){
        return listOfProductInStock.getStockRegister().stream().mapToDouble(OrderSale::getTotalPriceSale).sum();
    }

}
