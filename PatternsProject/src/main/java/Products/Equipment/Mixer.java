package Products.Equipment;

import Products.EquipmentClass;

public class Mixer extends EquipmentClass {
    public Mixer() {
        setProductID("13");
        setName(Mixer.class.getSimpleName());
        setDescription("Just like the hand mixer, but for weaklings or people in a haste.");
        setUnitPrice(499.99);
        setWarrantyYears(5);
    }
}
