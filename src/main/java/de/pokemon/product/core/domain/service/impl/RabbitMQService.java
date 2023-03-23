package de.pokemon.product.core.domain.service.impl;

import de.pokemon.product.core.domain.model.CartProductDto;
import de.pokemon.product.core.domain.service.interfaces.IRabbitMQService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService implements IRabbitMQService {

    @Value("${topic.exchange}")
    private String exchange;
    @Value("${product.queue.key}")
    private String routingKey;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        super();
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendProductToCart(CartProductDto dto) {
        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
    }
}
