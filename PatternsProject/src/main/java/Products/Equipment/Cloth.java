package Products.Equipment;

import Products.EquipmentClass;

public class Cloth extends EquipmentClass {

    public Cloth() {
        setProductID(3);
        setName(Cloth.class.getSimpleName());
        setDescription("A rag used for cleaning and such stuff");
        setUnitPrice(1.99);
        setWarrantyYears(0);
    }
}
