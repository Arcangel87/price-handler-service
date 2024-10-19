package internal.ecommerce.pricehandler.domain.repository;

import internal.ecommerce.pricehandler.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing brand data.
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
