package internal.ecommerce.pricehandler.domain.repository;

import internal.ecommerce.pricehandler.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
