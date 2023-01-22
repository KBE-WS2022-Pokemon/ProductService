package de.pokemon.warehouse.core.domain.service.interfaces;

import de.pokemon.warehouse.core.domain.model.CartProductDto;
import org.springframework.stereotype.Service;

@Service
public interface IRabbitMQService {

    void sendProductToCart(CartProductDto dto);
}
