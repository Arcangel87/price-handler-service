package internal.ecommerce.pricehandler.integration;

import static org.assertj.core.api.Assertions.assertThat;

import internal.ecommerce.pricehandler.domain.service.PriceService;
import internal.ecommerce.pricehandler.infrastructure.dto.PriceResponse;
import java.math.BigDecimal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

/**
 * Integration tests for the Price Handler Service.
 *
 * <p>
 * This test class verifies the correct functionality of the price query endpoint
 * under various scenarios using parameterized tests.
 * contains all test specified on Requirements.md
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceHandlerServiceIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @ParameterizedTest
    @CsvSource({
            "35455, 1, 2020-06-14T10:00:00, 35.50",
            "35455, 1, 2020-06-14T16:00:00, 25.45",
            "35455, 1, 2020-06-14T21:00:00, 35.50",
            "35455, 1, 2020-06-15T10:00:00, 30.50",
            "35455, 1, 2020-06-16T21:00:00, 38.95"
    })
    void testPriceAtDifferentTimes(Long productId, Long brandId, String applicationDate, BigDecimal expectedPrice) {
        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(
                "/price?productId=" + productId + "&brandId=" + brandId + "&applicationDate=" + applicationDate,
                PriceResponse.class
        );
        assertThat(response.getBody().getPrice()).isEqualByComparingTo(expectedPrice);
    }
}

