package de.pokemon.product.core.domain.service.interfaces;

import de.pokemon.product.core.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {}
