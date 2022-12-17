package de.pokemon.warehouse.core.domain.service.interfaces;

import de.pokemon.warehouse.core.domain.model.Product;
import de.pokemon.warehouse.port.product.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    Iterable<Product> getAllProducts();

    Product getProduct(Long id) throws ProductNotFoundException;

    Product save(Product product);

    void deleteProduct(Long id);
}
