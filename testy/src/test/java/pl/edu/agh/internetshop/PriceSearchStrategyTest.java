package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PriceSearchStrategyTest {
    @Test
    public void testPriceFilter() throws Exception {
        // given
        BigDecimal price = BigDecimal.valueOf(13.37);
        Order order = mock(Order.class);
        given(order.getPrice()).willReturn(price);
        PriceSearchStrategy priceSearchStrategy = new PriceSearchStrategy(price);

        // when
        boolean result = priceSearchStrategy.filter(order);

        // then
        assertTrue(result);
    }
}
