package internal.ecommerce.pricehandler.domain.repository;

import internal.ecommerce.pricehandler.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing product data.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
