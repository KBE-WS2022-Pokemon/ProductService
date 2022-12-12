package de.pokemon.warehouse.core.domain.service.impl;

import de.pokemon.warehouse.core.domain.model.Product;
import de.pokemon.warehouse.core.domain.service.interfaces.IProductService;
import de.pokemon.warehouse.core.domain.service.interfaces.ProductRepository;
import de.pokemon.warehouse.port.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }


    //public Optional<Product> getProductById(UUID id) throws ProductNotFoundException {Optional<Product> savedProduct = productRepository.findById(id);}

    public Product getProduct(UUID id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product %s not found.", id)));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
