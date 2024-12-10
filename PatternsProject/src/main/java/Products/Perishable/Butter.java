package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Butter extends PerishableClass {
    public Butter() {
        setProductID("38");
        setName(Bread.class.getSimpleName());
        setDescription("Goes well with bread and other wheat related stuff.");
        setUnitPrice(6.99);
        setExpirationDate(LocalDateTime.now().plusMonths(6));
    }
}
