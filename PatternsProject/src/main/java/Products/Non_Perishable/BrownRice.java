package Products.Non_Perishable;

import Products.Equipment.Apron;
import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class BrownRice extends NonPerishableClass {
    public BrownRice() {
        setProductID(21);
        setName(BrownRice.class.getSimpleName());
        setDescription("Tasty rice. Kinda dark, hence it's brown.");
        setUnitPrice(15.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(10));
    }
}
