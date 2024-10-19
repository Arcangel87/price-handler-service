package internal.ecommerce.pricehandler.infrastructure.controller;

import internal.ecommerce.pricehandler.domain.model.Brand;
import internal.ecommerce.pricehandler.domain.model.Price;
import internal.ecommerce.pricehandler.domain.model.Product;
import internal.ecommerce.pricehandler.domain.service.PriceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    private static final long BRAND_ID = 1;

    private static final long PRODUCT_ID = 35455;

    private static final BigDecimal PRICE = new BigDecimal("35.50");

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @Mock
    private Brand brand;
    @Mock
    private Product product;
    @Mock
    private Price price;

    @Test
    void getPrice() throws Exception {
        // Given
        when(priceService.getApplicablePrice(eq(PRODUCT_ID), eq(BRAND_ID), any(LocalDateTime.class))).thenReturn(price);
        when(price.getPrice()).thenReturn(PRICE);

        // When & Then
        mockMvc.perform(get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void getPrice_NotFound() throws Exception {
        // Given
        when(priceService.getApplicablePrice(eq(PRODUCT_ID), eq(BRAND_ID), any(LocalDateTime.class))).thenReturn(null);

        // When & Then
        mockMvc.perform(get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("applicationDate", "2020-06-14T10:00:00"))
                .andExpect(status().isNotFound());
    }
}