package de.pokemon.product.port.product;

import de.pokemon.product.core.domain.model.CartProductDto;
import de.pokemon.product.core.domain.model.Product;
import de.pokemon.product.core.domain.service.interfaces.IProductConverter;
import de.pokemon.product.core.domain.service.interfaces.IProductService;
import de.pokemon.product.core.domain.service.interfaces.IRabbitMQService;
import de.pokemon.product.port.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

@RestController
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
    public @ResponseBody Product getProduct(@PathVariable UUID id) throws ProductNotFoundException {
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/product/cart/{id}")
    public ResponseEntity<String> addToCart(@PathVariable UUID id, @RequestBody Map<String, String> input, Principal principal) throws ProductNotFoundException {
        int amountBought = Integer.parseInt(input.get("amountBought"));

        if(amountBought == 0) {
            return new ResponseEntity<>("False Input", HttpStatus.BAD_REQUEST);
        }
        if(amountBought > productService.getProduct(id).getInStorage()) {
            return new ResponseEntity<>("Products sold out", HttpStatus.METHOD_NOT_ALLOWED);
        }
        if(principal.getName() == null) {
            return new ResponseEntity<>("Couldn't retrieve user", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        Product productToConvert = productService.getProduct(id);
        CartProductDto productToSend = productConverter.convertToCart(productToConvert, amountBought, principal.getName());
        rabbitMQService.sendProductToCart(productToSend);
        return new ResponseEntity<>("Product " + productToSend.getItemName() + " with ID: " + productToSend.getUuid() +" added to Cart", HttpStatus.OK);
    }

    @GetMapping("/product/user")
    public ResponseEntity<String> getUserFromProduct(Principal principal) {
        return new ResponseEntity<String>("User name: " + principal, HttpStatus.OK);
    }

}
