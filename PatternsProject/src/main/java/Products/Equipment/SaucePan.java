package Products.Equipment;

import Products.EquipmentClass;

public class SaucePan extends EquipmentClass {
    public SaucePan() {
        setProductID("16");
        setName(SaucePan.class.getSimpleName());
        setDescription("Tool required for boiling foods and liquids.");
        setUnitPrice(69.99);
        setWarrantyYears(1);
    }
}
