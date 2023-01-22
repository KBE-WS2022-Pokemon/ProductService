package de.pokemon.warehouse.core.domain.service.impl;

import de.pokemon.warehouse.core.domain.model.CartProductDto;
import de.pokemon.warehouse.core.domain.model.Product;
import de.pokemon.warehouse.core.domain.service.interfaces.IProductConverter;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter implements IProductConverter {
    @Override
    public CartProductDto convert(Product product) {
        try {
            CartProductDto convertedProduct = new CartProductDto(
                    product.getUuid(),
                    product.getName(),
                    product.getPrice(),
                    product.getAmount()
            );
            return convertedProduct;
        } catch (NullPointerException ex) {
            //Product is empty or contains empty field
            return null;
        }

    }
}
