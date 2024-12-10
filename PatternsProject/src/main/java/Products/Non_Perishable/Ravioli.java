package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class Ravioli extends NonPerishableClass {
    public Ravioli() {
        setProductID("30");
        setName(Ravioli.class.getSimpleName());
        setDescription("'Ravioli Ravioli, give me the secret formuioli.'");
        setUnitPrice(8.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(6));
    }
}
