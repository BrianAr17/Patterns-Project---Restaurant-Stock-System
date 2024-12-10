package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Bread extends PerishableClass {
    public Bread() {
        setProductID("37");
        setName(Bread.class.getSimpleName());
        setDescription("A loaf a day won't keep the doctor away...");
        setUnitPrice(2.99);
        setExpirationDate(LocalDateTime.now().plusWeeks(2));
    }
}
