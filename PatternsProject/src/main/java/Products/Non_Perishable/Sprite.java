package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class Sprite extends NonPerishableClass {
    public Sprite() {
        setProductID("33");
        setName(Sprite.class.getSimpleName());
        setDescription("Want a sprite?");
        setUnitPrice(2.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(4));
    }
}
