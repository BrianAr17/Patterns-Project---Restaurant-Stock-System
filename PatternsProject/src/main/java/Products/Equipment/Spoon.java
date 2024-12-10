package Products.Equipment;

import Products.EquipmentClass;

public class Spoon extends EquipmentClass {
    public Spoon() {
        setProductID("18");
        setName(Spoon.class.getSimpleName());
        setDescription("Ever tried drinking from a fork before? Yeah that sucks, don't it. That's why there are spoons.");
        setUnitPrice(3.99);
        setWarrantyYears(0);
    }
}
