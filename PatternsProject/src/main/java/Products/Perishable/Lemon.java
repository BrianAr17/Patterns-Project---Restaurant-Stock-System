package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Lemon extends PerishableClass {
    public Lemon() {
        setProductID("43");
        setName(Lemon.class.getSimpleName());
        setDescription("When life gives you lemons...");
        setUnitPrice(1.99);
        setExpirationDate(LocalDateTime.now().plusWeeks(6));
    }
}
