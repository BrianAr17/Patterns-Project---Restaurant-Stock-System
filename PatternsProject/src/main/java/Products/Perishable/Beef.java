package Products.Perishable;

import Products.PerishableClass;

import java.time.LocalDateTime;

public class Beef extends PerishableClass {
    public Beef() {
        setProductID(36);
        setName(Beef.class.getSimpleName());
        setDescription("It used to go 'moo'. Now it 'moves' into my mouth.");
        setUnitPrice(29.99);
        setExpirationDate(LocalDateTime.now().plusMonths(3));
    }

    public Beef(int productId, String productName, String productDesc, double pricePerUnit, String productType) {
        setProductID(productId);
        setName(productName);
        setDescription(productDesc);
        setUnitPrice(pricePerUnit);
    }
}
