package de.pokemon.product.core.domain.service.interfaces;

import de.pokemon.product.core.domain.model.CartProductDto;
import org.springframework.stereotype.Service;

@Service
public interface IRabbitMQService {
    void sendProductToCart(CartProductDto dto);
}
