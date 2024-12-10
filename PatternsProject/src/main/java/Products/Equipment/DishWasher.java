package Products.Equipment;

import Products.EquipmentClass;

public class DishWasher extends EquipmentClass {
    public DishWasher() {
        setProductID("4");
        setName(DishWasher.class.getSimpleName());
        setDescription("A useful device to wash your dishes. This one's industrial so it's more expensive");
        setUnitPrice(9999.99);
        setWarrantyYears(10);
    }
}
