package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Egg extends PerishableClass {
    public Egg() {
        setProductID("40");
        setName(Egg.class.getSimpleName());
        setDescription("High school kids sure like throwing these. Jokes aside, they make up a pretty good omelet");
        setUnitPrice(0.99);
        setExpirationDate(LocalDateTime.now().plusWeeks(4));
    }
}
