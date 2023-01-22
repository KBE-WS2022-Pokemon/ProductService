package de.pokemon.warehouse.port.product;

import de.pokemon.warehouse.core.domain.model.CartProductDto;
import de.pokemon.warehouse.core.domain.model.Product;
import de.pokemon.warehouse.core.domain.service.interfaces.IProductConverter;
import de.pokemon.warehouse.core.domain.service.interfaces.IProductService;
import de.pokemon.warehouse.core.domain.service.interfaces.IRabbitMQService;
import de.pokemon.warehouse.port.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"https://localhost:3000/"})
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IRabbitMQService rabbitMQService;

    @Autowired
    private IProductConverter productConverter;

    @GetMapping("/")
    public String hello() {
        return "Hello World, I'm an API!";
    }

    @GetMapping("/product")
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Product getProduct(@PathVariable Long id) throws ProductNotFoundException {
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/product/cart/{id}")
    public ResponseEntity<String> addToCart(@PathVariable Long id) throws ProductNotFoundException {
        Product productToConvert = productService.getProduct(id);
        CartProductDto productToSend = productConverter.convert(productToConvert);
        rabbitMQService.sendProductToCart(productToSend);
        return new ResponseEntity<>("Product added to Cart", HttpStatus.OK);
    }

}