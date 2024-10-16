package internal.ecommerce.pricehandler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public record Price(
        Long brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long priceList,
        Long productId,
        Integer priority,
        BigDecimal price,
        String curr
){}