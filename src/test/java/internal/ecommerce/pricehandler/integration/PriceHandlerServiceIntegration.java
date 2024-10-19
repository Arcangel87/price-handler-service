package internal.ecommerce.pricehandler.integration;

import internal.ecommerce.pricehandler.domain.model.Price;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

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
        ResponseEntity<Price> response = restTemplate.getForEntity(
                "/price?productId=" + productId + "&brandId=" + brandId + "&applicationDate=" + applicationDate,
                Price.class
        );
        assertThat(response.getBody().getPrice()).isEqualByComparingTo(expectedPrice);
    }
}

