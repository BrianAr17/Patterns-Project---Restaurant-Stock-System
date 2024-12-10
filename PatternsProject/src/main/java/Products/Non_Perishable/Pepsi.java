package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class Pepsi extends NonPerishableClass {
    public Pepsi() {
        setProductID("29");
        setName(Pepsi.class.getSimpleName());
        setDescription("The actual best soda drink. Nothing tops water though.");
        setUnitPrice(2.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(4));
    }
}
