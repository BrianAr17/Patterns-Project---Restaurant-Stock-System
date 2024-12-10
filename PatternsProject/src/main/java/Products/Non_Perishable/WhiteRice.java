package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class WhiteRice extends NonPerishableClass {
    public WhiteRice() {
        setProductID("35");
        setName(WhiteRice.class.getSimpleName());
        setDescription("White people seem to like it better.");
        setUnitPrice(4.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(10));
    }
}
