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
    public CartProductDto convertToCart(Product product, int amountBought, Principal principal) {
        try {
            CartProductDto convertedProduct = new CartProductDto(
                    product.getUuid(),
                    principal.getName(),
                    product.getName(),
                    product.getPrice(),
                    amountBought
            );
            return convertedProduct;
        } catch (NullPointerException ex) {
            //Product is empty or contains empty field
            return null;
        }

    }
}
