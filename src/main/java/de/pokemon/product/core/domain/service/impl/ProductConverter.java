package de.pokemon.product.core.domain.service.impl;

import de.pokemon.product.core.domain.model.CartProductDto;
import de.pokemon.product.core.domain.model.Product;
import de.pokemon.product.core.domain.service.interfaces.IProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class ProductConverter implements IProductConverter {

    @Override
    public CartProductDto convertToCart(Product product, int amountBought, String userName) throws NullPointerException{

        CartProductDto convertedProduct = new CartProductDto(
                product.getUuid(),
                userName,
                product.getName(),
                product.getPrice(),
                amountBought
        );
        return convertedProduct;
    }
}
