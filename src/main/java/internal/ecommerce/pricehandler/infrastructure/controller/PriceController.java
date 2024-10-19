package internal.ecommerce.pricehandler.infrastructure.controller;

import internal.ecommerce.pricehandler.domain.model.Price;
import internal.ecommerce.pricehandler.domain.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping("/price")
    public ResponseEntity<Price> getPrice(
            @RequestParam Long productId,
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {
        Price price = priceService.getApplicablePrice(productId, brandId, applicationDate);
        return price == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(price);
    }
}


