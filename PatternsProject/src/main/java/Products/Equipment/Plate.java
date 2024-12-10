package Products.Equipment;

import Products.EquipmentClass;

public class Plate extends EquipmentClass {
    public Plate() {
        setProductID("15");
        setName(Plate.class.getSimpleName());
        setDescription("Ever got tired of eating off of the table? That's why the plates were made.");
        setUnitPrice(9.99);
        setWarrantyYears(0);
    }
}
