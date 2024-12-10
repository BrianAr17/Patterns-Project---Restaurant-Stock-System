package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class Spaghetti extends NonPerishableClass {
    public Spaghetti() {
        setProductID("32");
        setName(Spaghetti.class.getSimpleName());
        setDescription("There's a reason why spaghetti is the most known of all pastas.");
        setUnitPrice(3.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(6));
    }
}
