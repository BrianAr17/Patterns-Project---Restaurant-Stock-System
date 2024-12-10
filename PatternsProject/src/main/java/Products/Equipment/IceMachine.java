package Products.Equipment;

import Products.EquipmentClass;

public class IceMachine extends EquipmentClass {
    public IceMachine() {
        setProductID("10");
        setName(IceMachine.class.getSimpleName());
        setDescription("Machine that creates ice cubes from water. Pretty self explanatory.");
        setUnitPrice(2999.99);
        setWarrantyYears(10);
    }
}
