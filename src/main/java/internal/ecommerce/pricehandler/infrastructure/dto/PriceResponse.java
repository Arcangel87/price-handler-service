package internal.ecommerce.pricehandler.infrastructure.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *  This DTO is used to encapsulate the price's productId, brandId, priceList, startDate,
 *  endDate, price and curr.
 */
@Data
@Builder
@AllArgsConstructor
public class PriceResponse {

  private Long productId;
  private Long brandId;
  private Long priceList;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private BigDecimal price;
  private String curr;
}

