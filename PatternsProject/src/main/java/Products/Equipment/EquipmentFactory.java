package Products.Equipment;

import Products.EquipmentClass;
import Products.Factory;

public class EquipmentFactory implements Factory {

    /**
     * Generate the appropriate EquipmentClass object based on the String request.
     * @param request the object request in String format.
     * @return the EquipmentClass that corresponds to the request.
     */
    @Override
    public EquipmentClass getProduct(String request) {
        if (request.equalsIgnoreCase("APRON")) {
            return new Apron();
        } else if (request.equalsIgnoreCase("BOWL")) {
            return new Bowl();
        } else if (request.equalsIgnoreCase("CLOTH")) {
            return new Cloth();
        }
        return null;
    }
}
