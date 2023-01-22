package de.pokemon.product.core.domain.service.impl;

import de.pokemon.product.core.domain.model.Product;
import de.pokemon.product.core.domain.service.interfaces.IProductService;
import de.pokemon.product.core.domain.service.interfaces.IProductRepository;
import de.pokemon.product.port.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

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

    @Override
    public Product updateProductAmountInStorage(UUID productId, int amountToReduce) throws ProductNotFoundException {
        Product productToUpdate = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product %s not found.", productId)));
        int newAmount = productToUpdate.getInStorage() - amountToReduce;
        if(newAmount<0) {
            //throwCustomException
        }
        productToUpdate.setInStorage(newAmount);
        return productRepository.save(productToUpdate);
    }

}
