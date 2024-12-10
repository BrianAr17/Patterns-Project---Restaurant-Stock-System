package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Salmon extends PerishableClass {
    public Salmon() {
        setProductID("48");
        setName(Salmon.class.getSimpleName());
        setDescription("Arguably the best fish to eat. Tuna is a close second.");
        setUnitPrice(12.99);
        setExpirationDate(LocalDateTime.now().plusWeeks(3));
    }
}
