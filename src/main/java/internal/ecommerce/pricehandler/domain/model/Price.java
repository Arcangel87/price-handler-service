package internal.ecommerce.pricehandler.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public record Price(
        @ManyToOne
        @JoinColumn(name = "brand_id")
        Brand brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long priceList,
        @ManyToOne
        @JoinColumn(name = "product_id")
        Product productId,
        Integer priority,
        BigDecimal price,
        String curr
){}