import Products.Product;

import java.util.Date;

public class NonPerishable extends Product {

    // NonPerishable fields
    private Date bestBefore;

    public Date getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(Date bestBefore) {
        this.bestBefore = bestBefore;
    }

}
