package Products.Equipment;

import Products.EquipmentClass;

public class Grill extends EquipmentClass {
    public Grill() {
        setProductID("7");
        setName(Grill.class.getSimpleName());
        setDescription("If you wanna grill your meat, this is with what you do it: the grill");
        setUnitPrice(4999.99);
        setWarrantyYears(5);
    }
}
