package internal.ecommerce.pricehandler.domain.repository;

import internal.ecommerce.pricehandler.domain.model.Brand;
import internal.ecommerce.pricehandler.domain.model.Price;
import internal.ecommerce.pricehandler.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Product productId, Brand brandId, LocalDateTime startDate, LocalDateTime endDate);
}
