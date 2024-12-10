package Products;

import Products.Equipment.EquipmentFactory;
import Products.Non_Perishable.Non_PerishableFactory;
import Products.Perishable.PerishableFactory;

public class AbstractProductFactory {
    
    public Factory getFactory(String request) {
        if (request.equalsIgnoreCase("Perishable")) {
            return new PerishableFactory();
        }
        else if(request.equalsIgnoreCase("Non-Perishable")){
            return new Non_PerishableFactory();
        }
        else if (request.equalsIgnoreCase("Equipment")) {
            return new EquipmentFactory();
        }
        else{
            return null;
        }
    }
}
