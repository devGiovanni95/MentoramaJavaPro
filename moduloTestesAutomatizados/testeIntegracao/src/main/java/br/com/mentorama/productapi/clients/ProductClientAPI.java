package br.com.mentorama.productapi.clients;

import br.com.mentorama.productapi.model.Product;
import br.com.mentorama.productapi.model.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductClientAPI {

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
