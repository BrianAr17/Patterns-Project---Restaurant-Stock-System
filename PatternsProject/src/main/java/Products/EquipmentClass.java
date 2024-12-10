package Products;

/**
 * EquipmentClass is used to represent all products that are equipments.
 */
public abstract class EquipmentClass extends Product {
    private static int warrantyYears;

    public static void setWarrantyYears(int warrantyYears) {
        EquipmentClass.warrantyYears = warrantyYears;
    }

    public EquipmentClass() {

    }
}
