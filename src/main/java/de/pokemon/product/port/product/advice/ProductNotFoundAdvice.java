package de.pokemon.product.port.product.advice;

import de.pokemon.product.port.product.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductNotFoundAdvice extends ResponseEntityExceptionHandler{

    @ResponseBody
    @ExceptionHandler(value = { ProductNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected String handleProductNotFound(ProductNotFoundException ex) {
        return ex.getMessage();
    }
}
