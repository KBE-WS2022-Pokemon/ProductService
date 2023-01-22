package de.pokemon.warehouse.core.domain.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartProductDto implements Serializable {

    private Long uuid;
    private String name;
    private double price;
    private double amount;

}
