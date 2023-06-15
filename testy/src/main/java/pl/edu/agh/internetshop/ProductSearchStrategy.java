package pl.edu.agh.internetshop;

public class ProductSearchStrategy implements SearchStrategy {
    private final String productName;

    public ProductSearchStrategy(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean filter(Order order) {
        Product[] products = order.getProducts();
        for (Product product : products) {
            if (product.getName().equals(productName)) return true;
        }
        return false;
    }
}
