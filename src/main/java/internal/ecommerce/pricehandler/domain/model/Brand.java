package internal.ecommerce.pricehandler.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BRANDS")
@Data
public class Brand {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
        String name;
}