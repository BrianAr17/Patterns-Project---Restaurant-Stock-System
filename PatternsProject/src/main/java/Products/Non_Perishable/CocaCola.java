package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class CocaCola extends NonPerishableClass {
    public CocaCola() {
        setProductID("23");
        setName(CocaCola.class.getSimpleName());
        setDescription("Some will say that this is the best drink ever. But we all know it's Pepsi...");
        setUnitPrice(2.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(4));
    }
}
