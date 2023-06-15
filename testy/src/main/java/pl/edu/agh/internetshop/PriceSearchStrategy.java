package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class PriceSearchStrategy implements SearchStrategy {
    private final BigDecimal orderPrice;

    public PriceSearchStrategy(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public boolean filter(Order order) {
        return order.getPrice().compareTo(orderPrice) == 0;
    }
}
