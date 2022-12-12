package de.pokemon.warehouse.core.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;

    //@NotNull(message = "Product name is required")
    @Basic(optional = false)
    private String name;

    private Double price;

    private Double amount;

    private String description;

    private int inStorage;

    //private String imageUrl
}
