package internal.ecommerce.pricehandler.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Entity
@Table(name = "PRICES")
@Data
public class Price{
        @ManyToOne
        @JoinColumn(name = "brand_id")
        Brand brandId;
        LocalDateTime startDate;
        LocalDateTime endDate;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long priceList;
        @ManyToOne
        @JoinColumn(name = "product_id")
        Product productId;
        Integer priority;
        BigDecimal price;
        String curr;
}