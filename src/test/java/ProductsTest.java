import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ProductsTest {

    @Test
    public void getProducts() {
        Products myProducts = new Products();

        assertTrue(myProducts.getProducts().isEmpty());

        Product chocolate = new Product("chocolate", 3.0, 0.21);
        Product beer = new Product("beer", 1.5, 0.06);

        myProducts.add(chocolate);
        assertEquals(1, myProducts.getProducts().size());
        assertTrue(myProducts.getProducts().contains(chocolate));
        assertFalse(myProducts.getProducts().contains(beer));

        //if we add the same product twice, size of products should remain the same
        myProducts.add(chocolate);
        assertEquals(1, myProducts.getProducts().size());

        myProducts.remove(chocolate);
        assertEquals(1, myProducts.getProducts().size());

        myProducts.remove(chocolate);
        assertTrue(myProducts.getProducts().isEmpty());
    }

    @Test
    public void getProductCount() {
        Products myProducts = new Products();

        Product chocolate = new Product("chocolate", 3.0, 0.21);
        Product beer = new Product("beer", 1.5, 0.06);

        assertEquals(0, myProducts.getProductCount(chocolate));
        assertEquals(0, myProducts.getProductCount(beer));


        for (int i = 0; i < 50; i++) {

            assertEquals(i, myProducts.getProductCount(chocolate));
            assertEquals(0, myProducts.getProductCount(beer));

            myProducts.add(chocolate);
        }

    }

    @Test
    public void remove() {

        Products myProducts = new Products();

        Product chocolate = new Product("chocolate", 3.0, 0.21);
        Product beer = new Product("beer", 1.5, 0.06);

        assertEquals(0, myProducts.getProductCount(chocolate));
        assertEquals(0, myProducts.getProductCount(beer));

        int max = 50;

        for (int i = 0; i < max; i++) {
            myProducts.add(chocolate);
        }

        for (int i = 0; i < max; i++) {
            assertEquals(max - i, myProducts.getProductCount(chocolate));
            myProducts.remove(chocolate);

        }

        assertEquals(0, myProducts.getProductCount(beer));
        try {
            myProducts.remove(beer);
            fail();
        } catch (RuntimeException ex) {
            assertEquals(0, myProducts.getProductCount(beer));
        }
    }

    @Test
    public void add1() {
        Products myProducts = new Products();

        Product chocolate = new Product("chocolate", 3.0, 0.21);
        Product beer = new Product("beer", 1.5, 0.06);


        assertEquals(0, myProducts.getProductCount(chocolate));
        myProducts.add(chocolate, 10);
        assertEquals(10, myProducts.getProductCount(chocolate));
    }

    @Test
    public void remove1() {

        Products myProducts = new Products();

        Product chocolate = new Product("chocolate", 3.0, 0.21);
        Product beer = new Product("beer", 1.5, 0.06);


        assertEquals(0, myProducts.getProductCount(chocolate));
        myProducts.add(chocolate, 10);
        assertEquals(10, myProducts.getProductCount(chocolate));


        myProducts.remove(chocolate, 8);
        assertEquals(2, myProducts.getProductCount(chocolate));

        try {
            myProducts.remove(chocolate, 7);
            fail();
        } catch (RuntimeException ex) {
            assertEquals(2, myProducts.getProductCount(chocolate));
        }

        myProducts.remove(chocolate, 2);
        assertEquals(0, myProducts.getProductCount(chocolate));
    }
}