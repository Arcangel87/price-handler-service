package internal.ecommerce.pricehandler.infrastructure.controller;

import internal.ecommerce.pricehandler.domain.model.Price;
import internal.ecommerce.pricehandler.domain.service.PriceService;
import internal.ecommerce.pricehandler.infrastructure.dto.PriceResponse;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling price queries.
 * Provides an endpoint to query the applicable price for a product
 * based on the application date, product ID, and brand ID.
 */
@RestController
public class PriceController {

  @Autowired
  private PriceService priceService;

  @GetMapping("/price")
  public ResponseEntity<PriceResponse> getPrice(
      @RequestParam Long productId,
      @RequestParam Long brandId,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {
    Price price = priceService.getApplicablePrice(productId, brandId, applicationDate);
    return price == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(
        PriceResponse.builder()
            .productId(price.getProductId().getId())
            .brandId(price.getBrandId().getId())
            .priceList(price.getPriceList())
            .startDate(price.getStartDate())
            .endDate(price.getEndDate())
            .price(price.getPrice())
            .curr(price.getCurr())
            .build()
    );
  }
}


