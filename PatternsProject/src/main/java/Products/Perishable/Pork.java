package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Pork extends PerishableClass {
    public Pork() {
        setProductID("45");
        setName(Pork.class.getSimpleName());
        setDescription("GUYS! JOHN PORK IS CALLING!!!");
        setUnitPrice(19.99);
        setExpirationDate(LocalDateTime.now().plusMonths(4));
    }
}
