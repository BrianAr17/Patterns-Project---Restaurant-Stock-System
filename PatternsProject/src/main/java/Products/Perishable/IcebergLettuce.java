package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class IcebergLettuce extends PerishableClass {
    public IcebergLettuce() {
        setProductID("42");
        setName(IcebergLettuce.class.getSimpleName());
        setDescription("Most fast food places use this lettuce. However when I cook with it at home, I can never get it to taste the same...");
        setUnitPrice(1.99);
        setExpirationDate(LocalDateTime.now().plusWeeks(2));
    }
}
