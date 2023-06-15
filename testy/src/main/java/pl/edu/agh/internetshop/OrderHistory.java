package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistory {
    private final List<Order> orderHistory = new ArrayList<>();

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public List<Order> filter(SearchStrategy searchStrategy) {
        return orderHistory.stream().filter(searchStrategy::filter).collect(Collectors.toList());
    }
}
