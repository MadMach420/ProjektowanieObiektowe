package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class NameSearchStrategyTest {
    @Test
    public void testNameFilter() throws Exception {
        // given
        String name = "TestName";
        Order order = mock(Order.class);
        Shipment shipment = mock(Shipment.class);
        Address address = mock(Address.class);
        given(order.getShipment()).willReturn(shipment);
        given(shipment.getRecipientAddress()).willReturn(address);
        given(address.getName()).willReturn(name);
        NameSearchStrategy nameSearchStrategy = new NameSearchStrategy(name);

        // when
        boolean result = nameSearchStrategy.filter(order);

        // then
        assertTrue(result);
    }
}
