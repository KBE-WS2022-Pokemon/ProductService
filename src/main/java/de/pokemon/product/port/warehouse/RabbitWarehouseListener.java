package de.pokemon.product.port.warehouse;

import de.pokemon.product.core.domain.model.WarehouseUpdateDto;
import de.pokemon.product.core.domain.service.interfaces.IProductService;
import de.pokemon.product.port.product.exception.ProductNotFoundException;
import de.pokemon.product.port.rabbit.config.RabbitConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RabbitWarehouseListener {

    @Autowired
    private RabbitConfiguration rabbitConfig;
    @Autowired
    private IProductService productService;

    @RabbitListener(queues = { "${warehouse.queue.name}"})
    public void consume(WarehouseUpdateDto updateDto) throws ProductNotFoundException {
        productService.updateProductAmountInStorage(updateDto.getProductId(), updateDto.getAmountReduced());
    }
}
