package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class TomatoSauce extends NonPerishableClass {
    public TomatoSauce() {
        setProductID("34");
        setName(TomatoSauce.class.getSimpleName());
        setDescription("'No time to mush these tomatoes: Open a can and spread it already!'");
        setUnitPrice(2.99);
        setBestBeforeDate(LocalDateTime.now().plusYears(5));
    }
}
