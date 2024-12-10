package Products.Equipment;

import Products.EquipmentClass;

public class Oven extends EquipmentClass {
    public Oven() {
        setProductID("14");
        setName(Oven.class.getSimpleName());
        setDescription("Better than a microwave, worse than a grill. It works well with pastries though...");
        setUnitPrice(2999.99);
        setWarrantyYears(10);
    }
}
