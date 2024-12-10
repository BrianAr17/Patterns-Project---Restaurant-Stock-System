package Products.Equipment;

import Products.EquipmentClass;

public class Apron extends EquipmentClass {

    public Apron() {
        setProductID("1");
        setName(Apron.class.getSimpleName());
        setDescription("A piece of clothing the protects you from getting dirty");
        setUnitPrice(9.99);
        setWarrantyYears(0);
    }
}
