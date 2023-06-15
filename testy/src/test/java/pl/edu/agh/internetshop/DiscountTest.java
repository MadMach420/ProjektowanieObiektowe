package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class DiscountTest {
    @Test
    public void testGetPriceAfterDicount() throws Exception {
        // given
        BigDecimal expectedPrice = BigDecimal.valueOf(1);
        BigDecimal actualPrice = BigDecimal.valueOf(2);
        Discount discount = new Discount(BigDecimal.valueOf(0.5));

        // when
        actualPrice = discount.getPriceAfterDiscount(actualPrice);

        // then
        assertBigDecimalCompareValue(expectedPrice, actualPrice);
    }
}
