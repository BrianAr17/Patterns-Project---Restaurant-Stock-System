package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Goat extends PerishableClass {
    public Goat() {
        setProductID("41");
        setName(Goat.class.getSimpleName());
        setDescription("I just realized it should be lamb and not goat. Either way, it's surely edible.");
        setUnitPrice(39.99);
        setExpirationDate(LocalDateTime.now().plusMonths(4));
    }
}
