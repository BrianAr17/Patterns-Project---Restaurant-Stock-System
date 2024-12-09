import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static int product1;
    private static int product2;
    private static int product3;
    private static final int product1THRESHOLD = 100;
    private static final int product2THRESHOLD = 150;
    private static final int product3THRESHOLD = 300;

    // Get current product stock
    public static int getProduct1Stock() {
        return product1;
    }

    public static int getProduct2Stock() {
        return product2;
    }

    public static int getProduct3Stock() {
        return product3;
    }

    // Get current product threshold
    public static int getProduct1THRESHOLD() {
        return product1THRESHOLD;
    }

    public static int getProduct2THRESHOLD() {
        return product2THRESHOLD;
    }

    public static int getProduct3THRESHOLD() {
        return product3THRESHOLD;
    }

    public void addProduct(Delivery delivery) {
        HashMap<Product, Integer> map = delivery.getOrder().getOrder();

        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            if (entry.getKey().getClass().equals(PlaceholderProduct1.class)) {
                product1 += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(PlaceholderProduct2.class)) {
                product2 += entry.getValue();
            }
            else if (entry.getKey().getClass().equals(PlaceholderProduct3.class)) {
                product3 += entry.getValue();
            }
        }
        validateStock();
    }

    public void validateStock() {
        if (product1 > product1THRESHOLD) {
            product1 = product1THRESHOLD;
        }
        else if (product2 > product2THRESHOLD) {
            product2 = product2THRESHOLD;
        }
        else if (product3 > product3THRESHOLD) {
            product3 = product3THRESHOLD;
        }
    }

    public void consume(Product product) {
        if (product.getClass().equals(PlaceholderProduct1.class)) {
            product1--;
        }
        else if (product.getClass().equals(PlaceholderProduct1.class)) {
            product2--;
        }
        else if (product.getClass().equals(PlaceholderProduct1.class)) {
            product3--;
        }
    }

}
