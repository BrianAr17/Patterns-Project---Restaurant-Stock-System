package Products.Equipment;

import Products.EquipmentClass;

public class HandMixer extends EquipmentClass {
    public HandMixer() {
        setProductID("8");
        setName(HandMixer.class.getSimpleName());
        setDescription("Need to cook up some good cream with a hint of personal touch? Behold! The hand mixer!");
        setUnitPrice(12.99);
        setWarrantyYears(0);
    }
}
