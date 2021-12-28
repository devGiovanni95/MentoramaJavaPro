package br.com.mentorama.vendas.clients;

import br.com.mentorama.vendas.model.Product;
import br.com.mentorama.vendas.model.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductClienteAPI {

    @Value("${product.api.url}")
    private String url;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Product> findAll(){
        ResponseEntity<ProductDTO> responseEntity =
                new RestTemplate().getForEntity(url, ProductDTO.class);
        return responseEntity.getBody().getProducts();
    }
}
