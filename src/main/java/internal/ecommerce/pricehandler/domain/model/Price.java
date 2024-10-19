package internal.ecommerce.pricehandler.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Represent a price in the system
 * This entity is mapped to the "PRICES" table in the database
 */
@Entity
@Table(name = "PRICES")
@Data
public class Price {

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