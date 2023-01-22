package de.pokemon.warehouse.core.domain.service.interfaces;

import de.pokemon.warehouse.core.domain.model.Product;
import de.pokemon.warehouse.port.product.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IProductService {
    Iterable<Product> getAllProducts();

    Product getProduct(UUID id) throws ProductNotFoundException;

    Product save(Product product);

    void deleteProduct(UUID id);
}
