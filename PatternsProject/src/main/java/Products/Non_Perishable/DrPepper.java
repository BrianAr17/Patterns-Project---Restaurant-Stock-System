package Products.Non_Perishable;

import Products.NonPerishableClass;

import java.time.LocalDateTime;

public class DrPepper extends NonPerishableClass {
    public DrPepper() {
        setProductID("24");
        setName(DrPepper.class.getSimpleName());
        setDescription("Cherry flavoured drink. Don't mix it up with Cherry Cola.");
        setUnitPrice(2.99);
        setBestBeforeDate(LocalDateTime.now().plusMonths(4));
    }
}
