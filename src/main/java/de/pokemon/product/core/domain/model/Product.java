package de.pokemon.product.core.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID uuid;

    //@NotNull(message = "Product name is required")
    @Basic(optional = false)
    private String name;

    private Double price;

    private Double amount;

    @Column(columnDefinition="TEXT")
    private String description;

    private int inStorage;

    public Product(String name, Double price, Double amount, String description, int inStorage, String imageUrl) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.inStorage = inStorage;
        this.imageUrl = imageUrl;
    }

    /**
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    */
    private String imageUrl;

}
