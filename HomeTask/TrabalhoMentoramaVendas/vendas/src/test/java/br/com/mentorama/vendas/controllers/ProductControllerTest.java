package br.com.mentorama.vendas.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    private static final String MOCKED_RESULT = "{ \"products\" : [\n" +
            "   {\n" +
            "   \"id\": 1, \n" +
            "   \"productName\": \"TESTE\",\n" +
            "   \"quantityInStock\": \"10\",\n" +
            "   \"price\": 10.0\n" +
            "   },\n" +
            "   {\n" +
            "   \"id\": 1,\n" +
            "   \"productName\": \"TESTE\",\n" +
            "   \"quantityInStock\": \"10\",\n" +
            "   \"price\": 10.0\n" +
            "}\n" +
            "]}";

    private static WireMockServer wireMockServer = new WireMockServer(options().port(8080));

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll(){
        wireMockServer.start();
    }

    @BeforeEach
    void setUp(){
        wireMockServer.resetAll();
    }

    @AfterAll
    static void afterAll(){
        wireMockServer.stop();
    }

    @Test
    public void shouldFindAllProducts() throws  Exception{
        wireMockServer.stubFor(
                WireMock.get(WireMock.urlPathEqualTo("/product"))
                .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type","application/json")
                .withBody((MOCKED_RESULT))));

        mockMvc.perform(
                get("/product").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}