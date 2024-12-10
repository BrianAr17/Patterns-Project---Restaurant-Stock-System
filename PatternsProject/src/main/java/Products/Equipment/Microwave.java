package Products.Equipment;

import Products.EquipmentClass;

public class Microwave extends EquipmentClass {
    public Microwave() {
        setProductID("12");
        setName(Microwave.class.getSimpleName());
        setDescription("\"Nuke the food!\" The Americans said. The microwave does just that");
        setUnitPrice(999.99);
        setWarrantyYears(5);
    }
}
