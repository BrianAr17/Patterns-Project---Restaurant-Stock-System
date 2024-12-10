package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class OliveOil extends NonPerishableClass {
    public OliveOil() {
        setProductID("28");
        setName(OliveOil.class.getSimpleName());
        setDescription("Oil made from olives. I wonder why it's often called 'Extra Virgin'");
        setUnitPrice(5.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(9));
    }
}
