package de.pokemon.product.core.domain.service.interfaces;

import de.pokemon.product.core.domain.model.Product;
import de.pokemon.product.port.product.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IProductService {
    Iterable<Product> getAllProducts();

    Product getProduct(UUID id) throws ProductNotFoundException;

    Product save(Product product);

    void deleteProduct(UUID id);

    Product updateProductAmountInStorage(UUID productID, int amountToReduce) throws ProductNotFoundException;
}
