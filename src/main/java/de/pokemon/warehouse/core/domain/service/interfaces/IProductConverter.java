package de.pokemon.warehouse.core.domain.service.interfaces;

import de.pokemon.warehouse.core.domain.model.CartProductDto;
import de.pokemon.warehouse.core.domain.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface IProductConverter {

    CartProductDto convert(Product product, int amountBought);
}
