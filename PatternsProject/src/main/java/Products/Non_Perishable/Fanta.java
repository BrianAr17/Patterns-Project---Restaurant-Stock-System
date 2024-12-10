package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class Fanta extends NonPerishableClass {
    public Fanta() {
        setProductID("25");
        setName(Fanta.class.getSimpleName());
        setDescription("Tasty rice. Kinda dark, hence it's brown.");
        setUnitPrice(2.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(4));
    }
}
