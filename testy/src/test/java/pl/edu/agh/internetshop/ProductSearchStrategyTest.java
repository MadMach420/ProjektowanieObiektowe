package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ProductSearchStrategyTest {
    @Test
    public void testProductFilter() throws Exception {
        // given
        String name = "TestName";
        Product product = mock(Product.class);
        Order order = mock(Order.class);
        given(product.getName()).willReturn(name);
        given(order.getProducts()).willReturn(new Product[]{ product });
        ProductSearchStrategy productSearchStrategy = new ProductSearchStrategy(name);

        // when
        boolean result = productSearchStrategy.filter(order);

        // then
        assertTrue(result);
    }
}
