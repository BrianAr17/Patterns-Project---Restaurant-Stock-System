package Products.Equipment;

import Products.EquipmentClass;

public class Skillet extends EquipmentClass {
    public Skillet() {
        setProductID("17");
        setName(Skillet.class.getSimpleName());
        setDescription("Don't know much about skillets except that you need skill to use 'em. Haha, get it? 'Skill'? (There's a reason why I'm a programmer)");
        setUnitPrice(89.99);
        setWarrantyYears(1);
    }
}
