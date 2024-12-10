package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Tuna extends PerishableClass {
    public Tuna() {
        setProductID("50");
        setName(Tuna.class.getSimpleName());
        setDescription("Tuna is surprisingly versatile, ranging from sandwiches to cans.");
        setUnitPrice(11.99);
        setExpirationDate(LocalDateTime.now().plusWeeks(3));
    }
}
