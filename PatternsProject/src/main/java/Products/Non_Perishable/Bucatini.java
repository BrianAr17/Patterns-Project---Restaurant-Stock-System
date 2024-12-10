package Products.Non_Perishable;

import Products.Equipment.Apron;
import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class Bucatini extends NonPerishableClass {
    public Bucatini() {
        setProductID("22");
        setName(Bucatini.class.getSimpleName());
        setDescription("Bucatini. Kinda looks like linguini according to Andrew. Personally I don't see it...");
        setUnitPrice(6.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(6));
    }
}
