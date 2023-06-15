package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrderHistoryTest {
    @Test
    public void testOrderHistoryFilter() throws Exception {
        // given
        Order order = mock(Order.class);

        String name = "TestName";
        Shipment shipment = mock(Shipment.class);
        Address address = mock(Address.class);
        given(order.getShipment()).willReturn(shipment);
        given(shipment.getRecipientAddress()).willReturn(address);
        given(address.getName()).willReturn(name);
        NameSearchStrategy nameSearchStrategy = new NameSearchStrategy(name);

        BigDecimal price = BigDecimal.valueOf(13.37);
        given(order.getPrice()).willReturn(price);
        PriceSearchStrategy priceSearchStrategy = new PriceSearchStrategy(price);

        name = "TestName";
        Product product = mock(Product.class);
        given(product.getName()).willReturn(name);
        given(order.getProducts()).willReturn(new Product[]{ product });
        ProductSearchStrategy productSearchStrategy = new ProductSearchStrategy(name);

        CompositeSearchStrategy compositeSearchStrategy = new CompositeSearchStrategy(
                nameSearchStrategy, priceSearchStrategy, productSearchStrategy
        );

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.addOrder(order);

        List<Order> expectedResult = new ArrayList<>();
        expectedResult.add(order);

        // when
        List<Order> actualResult = orderHistory.filter(compositeSearchStrategy);

        // then
        assertEquals(expectedResult, actualResult);
    }
}
