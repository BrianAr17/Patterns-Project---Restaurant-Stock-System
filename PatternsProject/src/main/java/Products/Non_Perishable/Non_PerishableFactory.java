package Products.Non_Perishable;

import Products.EquipmentClass;
import Products.Factory;
import Products.NonPerishableClass;
import Products.PerishableClass;

public class Non_PerishableFactory implements Factory {

    /***
     * NonPerisable items are made in the NonPerishable factory by the user's request
     * @param request request of soda
     * @return The non_perishable item
     */
    @Override
    public NonPerishableClass getProduct(String request) {
        if (request.equalsIgnoreCase("CocaCola")) {
            return new CocaCola();
        } else if (request.equalsIgnoreCase("BrownRice")) {
            return new BrownRice();
        } else if (request.equalsIgnoreCase("Bucatini")) {
            return new Bucatini();
        }
        return null;
    }
}
