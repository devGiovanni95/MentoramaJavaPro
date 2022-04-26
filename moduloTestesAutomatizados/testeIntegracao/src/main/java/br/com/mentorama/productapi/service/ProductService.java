package br.com.mentorama.productapi.service;

import br.com.mentorama.productapi.clients.ProductClientAPI;
import br.com.mentorama.productapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductClientAPI client;

    public List<Product> findAll(){
        return client.findAll();
    }
}
