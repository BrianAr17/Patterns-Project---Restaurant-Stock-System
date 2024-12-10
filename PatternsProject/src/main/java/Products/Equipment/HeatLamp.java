package Products.Equipment;

import Products.EquipmentClass;

public class HeatLamp extends EquipmentClass {
    public HeatLamp() {
        setProductID("9");
        setName(HeatLamp.class.getSimpleName());
        setDescription("Keeps your food on standby warm. Works wonders at McDonald's.");
        setUnitPrice(249.99);
        setWarrantyYears(5);
    }
}
