package de.pokemon.warehouse.core.domain.model;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class CartProductDto implements Serializable {

    @NonNull
    private Long uuid;
    @NonNull
    private String name;
    @NonNull
    private double price;
    @NonNull
    private double amount;

}
