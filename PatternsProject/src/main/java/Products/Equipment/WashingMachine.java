package Products.Equipment;

import Products.EquipmentClass;

public class WashingMachine extends EquipmentClass {
    public WashingMachine() {
        setProductID("19");
        setName(WashingMachine.class.getSimpleName());
        setDescription("Washes your clothes. Don't put a brick in it. Trust me, you don't wanna do that.");
        setUnitPrice(3999.99);
        setWarrantyYears(10);
    }
}
