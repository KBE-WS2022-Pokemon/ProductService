package de.pokemon.product.port.product.exception;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
