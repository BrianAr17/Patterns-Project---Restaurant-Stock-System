package Products.Equipment;

import Products.EquipmentClass;

public class WineOpener extends EquipmentClass {
    public WineOpener() {
        setProductID("20");
        setName(WineOpener.class.getSimpleName());
        setDescription("Can't open a bottle by brute strength and don't wanna look like a wuss? The wine opener is just right for you then.");
        setUnitPrice(9.99);
        setWarrantyYears(0);
    }
}
