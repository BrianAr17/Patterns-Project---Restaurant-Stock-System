package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Potato extends PerishableClass {
    public Potato() {
        setProductID("46");
        setName(Potato.class.getSimpleName());
        setDescription("The potato is truly an incredible vegetable (I don't care if it's technically not a vegetable it still is in my book)");
        setUnitPrice(0.49);
        setExpirationDate(LocalDateTime.now().plusWeeks(8));
    }
}
