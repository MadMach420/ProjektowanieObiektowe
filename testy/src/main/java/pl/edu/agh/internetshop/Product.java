package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final int ROUND_STRATEGY = BigDecimal.ROUND_HALF_UP;
	
    private final String name;
    private final BigDecimal price;
    private final Discount productDiscount = new Discount();

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
    }

    public void setDiscountValue(BigDecimal discountValue) {
        productDiscount.setDiscountValue(discountValue);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceAfterDiscount() {
        return productDiscount.getPriceAfterDiscount(price);
    }
}
