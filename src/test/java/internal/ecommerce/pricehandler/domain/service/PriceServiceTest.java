package internal.ecommerce.pricehandler.domain.service;

import internal.ecommerce.pricehandler.domain.model.Brand;
import internal.ecommerce.pricehandler.domain.model.Price;
import internal.ecommerce.pricehandler.domain.model.Product;
import internal.ecommerce.pricehandler.domain.repository.BrandRepository;
import internal.ecommerce.pricehandler.domain.repository.PriceRepository;
import internal.ecommerce.pricehandler.domain.repository.ProductRepository;
import internal.ecommerce.pricehandler.infrastructure.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    private static final long BRAND_ID = 1;

    private static final long PRODUCT_ID = 35455;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private Brand brand;

    @Mock
    private Product product;

    @Mock
    private Price price;

    @InjectMocks
    private PriceService priceService;

    @Test
    void getApplicablePrice() {
        //Given
        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
        when(brandRepository.findById(BRAND_ID)).thenReturn(Optional.of(brand));
        when(priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                eq(product),eq(brand),any(LocalDateTime.class),any(LocalDateTime.class))).thenReturn(List.of(price));

        //When
        Price applicablePrice = priceService.getApplicablePrice(PRODUCT_ID,BRAND_ID, LocalDateTime.now());

        //Then
        assertNotNull(applicablePrice);
        assertEquals(price, applicablePrice);

    }

    @Test
    void getApplicablePrice_BrandNotFound() {
        // Given
        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
        when(brandRepository.findById(BRAND_ID)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(ResourceNotFoundException.class, () -> {
            priceService.getApplicablePrice(PRODUCT_ID, BRAND_ID, LocalDateTime.now());
        });
    }

    @Test
    void getApplicablePrice_ProductNotFound() {
        //Given
        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(ResourceNotFoundException.class, () -> {
            priceService.getApplicablePrice(PRODUCT_ID, BRAND_ID, LocalDateTime.now());
        });
    }
}