import Products.Product;

import java.util.Date;

public class Perishable extends Product {

    // Perishable fields
    private Date expiryDate;

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public static class PlaceholderProduct3 extends Product {

    }
}
