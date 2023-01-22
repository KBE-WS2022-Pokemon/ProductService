package de.pokemon.warehouse.port.product;

import de.pokemon.warehouse.core.domain.model.Product;
import de.pokemon.warehouse.core.domain.service.interfaces.IProductService;
import de.pokemon.warehouse.port.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
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
        return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
    }


}
