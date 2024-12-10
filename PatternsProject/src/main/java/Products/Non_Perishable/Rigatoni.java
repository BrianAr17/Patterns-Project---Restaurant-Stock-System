package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class Rigatoni extends NonPerishableClass {
    public Rigatoni() {
        setProductID("31");
        setName(Rigatoni.class.getSimpleName());
        setDescription("Ring ring, who's that? Oh it's Ringatoni!");
        setUnitPrice(6.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(6));
    }
}
