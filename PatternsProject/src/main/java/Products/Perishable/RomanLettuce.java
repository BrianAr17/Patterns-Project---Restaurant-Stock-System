package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class RomanLettuce extends PerishableClass {
    public RomanLettuce() {
        setProductID("47");
        setName(RomanLettuce.class.getSimpleName());
        setDescription("Unlike it's title might suggest, it's not actually from Rome; it's from home");
        setUnitPrice(1.99);
        setExpirationDate(LocalDateTime.now().plusWeeks(2));
    }
}
