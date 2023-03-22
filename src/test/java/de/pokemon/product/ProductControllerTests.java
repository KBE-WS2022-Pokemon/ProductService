package de.pokemon.product;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.pokemon.product.core.domain.model.Product;
import de.pokemon.product.core.domain.service.interfaces.IProductConverter;
import de.pokemon.product.core.domain.service.interfaces.IProductService;
import de.pokemon.product.core.domain.service.interfaces.IRabbitMQService;
import de.pokemon.product.port.product.ProductRestController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductRestController.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProductControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IProductService productService;
    @MockBean
    private IRabbitMQService rabbitMQService;
    @MockBean
    private IProductConverter productConverter;

    @Test
    public void testGetProduct() throws Exception {

    }

    @Test
    public void testAddProduct() throws Exception {
        Product itemToAdd = new Product("Phenylpiracetam", 7.90, 400.0, "L-Phenylalanin ist eine wichtige Aminosäure, die im menschlichen Körper für verschiedene Funktionen verantwortlich ist. Es ist ein natürlich vorkommendes Molekül, das in vielen Proteinen enthalten ist und für die Bildung anderer Aminosäuren und Neurotransmitter wie Dopamin und Noradrenalin benötigt wird. L-Phenylalanin kann zur Stimmungsverbesserung beitragen und Schmerzen lindern.", 100, "https://storage.cloud.google.com/images_studropica/Phenylpiracetam.png?authuser=1");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemToAdd));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Phenylpiracetam"))
                .andExpect(jsonPath("$.price").value(7.90))
                .andExpect(jsonPath("$.amount").value(400.0));

    }

    @Test
    public void testAddProductWithIdGeneration() throws Exception {
        Product itemToAdd = new Product("Phenylpiracetam", 7.90, 400.0, "L-Phenylalanin ist eine wichtige Aminosäure, die im menschlichen Körper für verschiedene Funktionen verantwortlich ist. Es ist ein natürlich vorkommendes Molekül, das in vielen Proteinen enthalten ist und für die Bildung anderer Aminosäuren und Neurotransmitter wie Dopamin und Noradrenalin benötigt wird. L-Phenylalanin kann zur Stimmungsverbesserung beitragen und Schmerzen lindern.", 100, "https://storage.cloud.google.com/images_studropica/Phenylpiracetam.png?authuser=1");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemToAdd));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("Phenylpiracetam")))
                .andExpect(jsonPath("$.uuid", notNullValue()))
                .andExpect(jsonPath("$.price", is(7.90)))
                .andExpect(jsonPath("$.amount", is(400.0)));
    }


}