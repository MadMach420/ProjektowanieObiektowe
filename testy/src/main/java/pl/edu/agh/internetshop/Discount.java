package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Discount {
    public static final int DISCOUNT_PRECISION = 2;
    public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
    private BigDecimal discountValue;

    public Discount() {
        this.discountValue = BigDecimal.valueOf(0);
    }

    public Discount(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public BigDecimal getPriceAfterDiscount(BigDecimal price) {
        return price.multiply(discountValue);
    }
}
