package Products.Equipment;

import Products.EquipmentClass;

public class FryingPan extends EquipmentClass {
    public FryingPan() {
        setProductID("6");
        setName(FryingPan.class.getSimpleName());
        setDescription("Metal piece used to sizzle that meat. Works well with grease.");
        setUnitPrice(49.99);
        setWarrantyYears(1);
    }
}
