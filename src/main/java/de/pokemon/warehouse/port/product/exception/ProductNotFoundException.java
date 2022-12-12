package de.pokemon.warehouse.port.product.exception;

import java.util.UUID;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
