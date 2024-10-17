package internal.ecommerce.pricehandler.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Brand(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
        String name
) {}