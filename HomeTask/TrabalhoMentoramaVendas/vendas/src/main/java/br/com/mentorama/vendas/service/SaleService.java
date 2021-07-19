package br.com.mentorama.vendas.service;

import br.com.mentorama.vendas.clients.ProductClienteAPI;
import br.com.mentorama.vendas.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private ProductClienteAPI client;

    public List<Product> findAll(){
        return client.findAll();
    }
}
