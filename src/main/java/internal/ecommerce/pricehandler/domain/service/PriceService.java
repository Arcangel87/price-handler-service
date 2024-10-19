package internal.ecommerce.pricehandler.domain.service;

import internal.ecommerce.pricehandler.domain.model.Brand;
import internal.ecommerce.pricehandler.domain.model.Price;
import internal.ecommerce.pricehandler.domain.model.Product;
import internal.ecommerce.pricehandler.domain.repository.BrandRepository;
import internal.ecommerce.pricehandler.domain.repository.PriceRepository;
import internal.ecommerce.pricehandler.domain.repository.ProductRepository;
import internal.ecommerce.pricehandler.infrastructure.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;

    public Price getApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Product not found with ID: " + productId));
        Brand brand = brandRepository.findById(brandId).orElseThrow(() ->
                new ResourceNotFoundException("Brand not found with ID: " + brandId));
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                product, brand, applicationDate, applicationDate);
        return prices.isEmpty() ? null : prices.get(0);
    }
}
