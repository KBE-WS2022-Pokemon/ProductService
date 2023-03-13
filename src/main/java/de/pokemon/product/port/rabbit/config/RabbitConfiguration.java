package de.pokemon.product.port.rabbit.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${topic.exchange}")
    private String exchange;
    @Value("${product.queue.name}")
    private String productQueue;
    @Value("${product.queue.key}")
    private String productRoutingKey;

    @Value("${warehouse.queue.name}")
    private String warehouseQueue;
    @Value("${warehouse.queue.key}")
    private String warehouseRoutingKey;


    @Bean
    public Queue createProductQueue() {
        return new Queue(productQueue);
    }

    @Bean
    public Queue createWarehouseQueue() { return new Queue(warehouseQueue); }

    @Bean
    public TopicExchange getExchange() { return new TopicExchange(exchange); }

    @Bean
    public Binding productBinding(){
        return BindingBuilder
                .bind(createProductQueue())
                .to(getExchange())
                .with(productRoutingKey);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
