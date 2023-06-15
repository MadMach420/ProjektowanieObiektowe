package pl.edu.agh.internetshop;

public class NameSearchStrategy implements SearchStrategy {
    private final String name;

    public NameSearchStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Order order) {
        String orderName = order.getShipment().getRecipientAddress().getName();
        return orderName.equals(name);
    }
}
