package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Chicken extends PerishableClass {
    public Chicken() {
        setProductID("39");
        setName(Chicken.class.getSimpleName());
        setDescription("Chickens can lay eggs pretty well. So why do we eat them? They're pretty tasty I suppose.");
        setUnitPrice(7.99);
        setExpirationDate(LocalDateTime.now().plusWeeks(3));
    }
}
