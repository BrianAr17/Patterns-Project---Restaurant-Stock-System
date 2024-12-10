package Products.Equipment;

import Products.EquipmentClass;

public class Fork extends EquipmentClass {
    public Fork() {
        setProductID("5");
        setName(Fork.class.getSimpleName());
        setDescription("A utensil with 4 spikes, used for stabbing your food");
        setUnitPrice(3.99);
        setWarrantyYears(0);
    }
}
