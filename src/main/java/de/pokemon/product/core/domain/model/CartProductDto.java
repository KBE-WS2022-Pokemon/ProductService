package de.pokemon.product.core.domain.model;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.security.Principal;
import java.util.UUID;

@Data
public class CartProductDto implements Serializable {

    @NonNull
    private UUID uuid;
    @NonNull
    private String userName;
    @NonNull
    private String itemName;
    @NonNull
    private double price;
    @NonNull
    private int amount;

}
