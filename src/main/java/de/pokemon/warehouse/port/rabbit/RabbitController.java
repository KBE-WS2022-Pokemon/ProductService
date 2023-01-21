package de.pokemon.warehouse.port.rabbit;

import de.pokemon.warehouse.core.domain.model.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitController {

    @Value("${topic.exchange}")
    private String exchange;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitController(RabbitTemplate rabbitTemplate) {
        super();
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceWithProduct(Product product) {

        rabbitTemplate.setExchange(exchange);
        //rabbitTemplate.send(product);

    }
}
