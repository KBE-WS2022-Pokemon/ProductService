package de.pokemon.warehouse.port.product;

import de.pokemon.warehouse.core.domain.model.Product;
import de.pokemon.warehouse.core.domain.service.interfaces.IProductService;
import de.pokemon.warehouse.port.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Product getProduct(@PathVariable UUID id) throws ProductNotFoundException {
        return productService.getProduct(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
    }


}
