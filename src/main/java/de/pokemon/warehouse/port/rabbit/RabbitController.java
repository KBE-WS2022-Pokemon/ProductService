package de.pokemon.warehouse.port.rabbit;

import de.pokemon.warehouse.core.domain.model.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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

    @RabbitListener(queues = { "$(product.queue.name)"})
    public void consume(Product product) {
        rabbitTemplate.setExchange(exchange);

    }
}
