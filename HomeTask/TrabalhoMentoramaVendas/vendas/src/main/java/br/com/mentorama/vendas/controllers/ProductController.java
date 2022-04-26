package br.com.mentorama.vendas.controllers;

import br.com.mentorama.vendas.model.Product;
import br.com.mentorama.vendas.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Product> findAll(){
        return saleService.findAll();
    }
}
