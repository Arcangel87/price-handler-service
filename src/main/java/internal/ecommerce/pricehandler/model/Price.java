package internal.ecommerce.pricehandler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public record Price(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
        int brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        int priceList,
        int productId,
        int priority,
        double price,
        String curr
){}