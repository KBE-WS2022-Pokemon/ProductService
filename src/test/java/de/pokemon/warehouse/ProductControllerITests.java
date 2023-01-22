package de.pokemon.warehouse;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.pokemon.warehouse.core.domain.service.interfaces.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductControllerITests {

    /**
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        productRepository.deleteAll();
    }

    @Test
    public void givenProductObject_whenCreateProduct_thenReturnSavedProduct() throws Exception {
        // given

        // when
        assert true;
        // then
    }
    */
}
