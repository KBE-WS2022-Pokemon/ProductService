package de.pokemon.warehouse.core.domain.model;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.UUID;

@Data
public class CartProductDto implements Serializable {

    @NonNull
    private UUID uuid;
    @NonNull
    private String name;
    @NonNull
    private double price;
    @NonNull
    private int amount;

}
