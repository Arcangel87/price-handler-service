package internal.ecommerce.pricehandler.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represent a product in the system
 * This entity is mapped to the "PRODUCTS" table in the database
 */
@Entity
@Table(name = "PRODUCTS")
@Data
public class Product {

  @Id
  Long id;
  String name;
  String description;
}
