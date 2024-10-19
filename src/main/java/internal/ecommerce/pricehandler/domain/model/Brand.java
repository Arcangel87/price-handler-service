package internal.ecommerce.pricehandler.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represent a brand in the system
 * This entity is mapped to the "BRANDS" table in the database
 */
@Entity
@Table(name = "BRANDS")
@Data
public class Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
}