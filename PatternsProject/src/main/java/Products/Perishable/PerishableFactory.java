package Products.Perishable;

import Products.EquipmentClass;
import Products.Factory;
import Products.NonPerishableClass;
import Products.PerishableClass;

public class PerishableFactory implements Factory {

    /**
     * Generate the appropriate PerishableClass based on the String request.
     * @param request the request in String format.
     * @return the appropriate PerishableClass based on the String format.
     */
    @Override
    public PerishableClass getProduct(String request) {
        if (request.equalsIgnoreCase("BEEF")) {
            return new Beef();
        } else if (request.equalsIgnoreCase("BREAD")) {
            return new Bread();
        } else if (request.equalsIgnoreCase("BUTTER")) {
            return new Butter();
        }
        return null;
    }
}
