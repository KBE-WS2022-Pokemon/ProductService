package de.pokemon.warehouse.port.rabbit.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${product.queue.name}")
    private String productQueue;

    @Value("${topic.exchange}")
    private String exchange;

    @Value("${product.queue.key}")
    private String productRoutingKey;

    @Bean
    public Queue createProductQueue() {
        return new Queue(productQueue);
    }

    @Bean
    public TopicExchange getExchange() { return new TopicExchange(exchange); }

    @Bean
    public Binding productBinding(){
        return BindingBuilder
                .bind(createProductQueue())
                .to(getExchange())
                .with(productRoutingKey);
    }


}
