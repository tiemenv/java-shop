import java.util.Objects;

public class Product {

    private String name;
    private double price;
    private double VAT;

    public Product(String name, double price, double VAT) {
        if (name == null || name.length() <= 0) {
            throw new IllegalArgumentException("A product must have a sensible name.");
        }

        if (price <= 0.0) {
            throw new IllegalArgumentException("A product must have a sensible price.");
        }

        if (VAT < 0.0) {
            throw new IllegalArgumentException("A product must have a sensible VAT.");
        }
        this.name = name;
        this.price = price;
        this.VAT = VAT;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
