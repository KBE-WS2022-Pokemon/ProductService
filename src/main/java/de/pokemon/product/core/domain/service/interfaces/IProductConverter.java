package de.pokemon.product.core.domain.service.interfaces;

import de.pokemon.product.core.domain.model.CartProductDto;
import de.pokemon.product.core.domain.model.Product;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface IProductConverter {

    CartProductDto convertToCart(Product product, int amountBought, Principal principal);
}
