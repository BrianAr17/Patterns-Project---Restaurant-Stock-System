package Products.Equipment;

import Products.EquipmentClass;

public class Bowl extends EquipmentClass {

    public Bowl() {
        setProductID("2");
        setName(Bowl.class.getSimpleName());
        setDescription("A rounded type of plate, very useful for containing liquids");
        setUnitPrice(4.99);
        setWarrantyYears(0);
    }
}
