package de.pokemon.warehouse.core.domain.service.impl;

import de.pokemon.warehouse.core.domain.model.CartProductDto;
import de.pokemon.warehouse.core.domain.service.interfaces.IRabbitMQService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class RabbitMQService implements IRabbitMQService {

    @Value("$(topic.exchange")
    private String exchange;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        super();
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendProductToCart(CartProductDto dto) {
        rabbitTemplate.convertAndSend("Hello, Cart Service!");
    }
}
