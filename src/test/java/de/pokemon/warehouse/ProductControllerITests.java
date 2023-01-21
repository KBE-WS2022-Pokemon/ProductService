package de.pokemon.warehouse;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


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
