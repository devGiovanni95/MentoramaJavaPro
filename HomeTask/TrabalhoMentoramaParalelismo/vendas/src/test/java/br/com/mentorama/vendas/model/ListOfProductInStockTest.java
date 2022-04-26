package br.com.mentorama.vendas.model;

import org.junit.jupiter.api.Test;

class ListOfProductInStockTest {

    private Object Product;

    @Test
    public void ImprimirLista(){
        ListOfProductInStock listOfProductInStock = new ListOfProductInStock(Product);

        listOfProductInStock.listar();
    }
}