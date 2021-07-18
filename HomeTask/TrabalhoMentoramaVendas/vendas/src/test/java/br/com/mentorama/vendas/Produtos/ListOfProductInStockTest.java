package br.com.mentorama.vendas.Produtos;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListOfProductInStockTest {

    private Object Product;

    @Test
    public void ImprimirLista(){
        ListOfProductInStock listOfProductInStock = new ListOfProductInStock(Product);

        listOfProductInStock.listar();
    }
}