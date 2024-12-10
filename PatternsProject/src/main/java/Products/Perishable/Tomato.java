package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Tomato extends PerishableClass {
    public Tomato() {
        setProductID("49");
        setName(Tomato.class.getSimpleName());
        setDescription("Tomato tomato, what's the difference?");
        setUnitPrice(0.69);
        setExpirationDate(LocalDateTime.now().plusWeeks(3));
    }
}
