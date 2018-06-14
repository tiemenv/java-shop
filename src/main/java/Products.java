import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Products {

    private Map<Product, Integer> products;

    public Products() {
        products = new HashMap<>();
    }

    public Set<Product> getProducts() {
        return products.keySet();
    }

    public int getProductCount(Product product) {
        return products.getOrDefault(product, 0);
    }

    public void add(Product product) {
        add(product, 1);
    }

    public void remove(Product product) {
        remove(product, 1);
    }

    public void add(Product product, int amount) {
        products.put(product, getProductCount(product) + amount);
    }

    public void remove(Product product, int amount) {
        int productCount = getProductCount(product);
        if (productCount < amount) {
            throw new RuntimeException("Not enough articles of the product present to delete the demanded amount.");
        } else if (productCount == amount) {
            products.remove(product);
        } else {
            products.put(product, getProductCount(product) - amount);
        }
    }
}
