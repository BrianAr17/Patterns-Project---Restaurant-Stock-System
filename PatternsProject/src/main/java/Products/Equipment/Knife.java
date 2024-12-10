package Products.Equipment;

import Products.EquipmentClass;

public class Knife extends EquipmentClass {
    public Knife() {
        setProductID("11");
        setName(Knife.class.getSimpleName());
        setDescription("Ever wished you could divide your food into smaller pieces? That's one of the uses of a knife!");
        setUnitPrice(3.99);
        setWarrantyYears(0);
    }
}
