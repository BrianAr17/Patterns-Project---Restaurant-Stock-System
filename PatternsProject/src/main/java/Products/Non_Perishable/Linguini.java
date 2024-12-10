package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class Linguini extends NonPerishableClass {
    public Linguini() {
        setProductID("27");
        setName(Linguini.class.getSimpleName());
        setDescription("You know what. It kinda does look like Bucatini. Andrew was right.");
        setUnitPrice(5.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(6));
    }
}
