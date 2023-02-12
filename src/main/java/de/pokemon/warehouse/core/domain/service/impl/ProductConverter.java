package de.pokemon.warehouse.core.domain.service.impl;

import de.pokemon.warehouse.core.domain.model.CartProductDto;
import de.pokemon.warehouse.core.domain.model.Product;
import de.pokemon.warehouse.core.domain.service.interfaces.IProductConverter;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter implements IProductConverter {
    @Override
    public CartProductDto convertToCart(Product product, int amountBought) {
        try {
            CartProductDto convertedProduct = new CartProductDto(
                    product.getUuid(),
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
