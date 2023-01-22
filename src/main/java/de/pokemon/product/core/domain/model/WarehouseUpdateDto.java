package de.pokemon.product.core.domain.model;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class WarehouseUpdateDto {

    @NonNull
    private UUID productId;
    @NonNull
    private int amountReduced;

}
