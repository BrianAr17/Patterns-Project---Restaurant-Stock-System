package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class Fettuccini extends NonPerishableClass {
    public Fettuccini() {
        setProductID("26");
        setName(Fettuccini.class.getSimpleName());
        setDescription("It's a kind of pasta. Not much else to be said. Don't get mad italians.");
        setUnitPrice(7.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(6));
    }
}
