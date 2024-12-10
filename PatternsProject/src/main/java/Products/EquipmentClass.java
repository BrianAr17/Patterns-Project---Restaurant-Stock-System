package Products;

public class EquipmentClass extends Product {
    private static int warrantyYears;

    public static void setWarrantyYears(int warrantyYears) {
        EquipmentClass.warrantyYears = warrantyYears;
    }

    public EquipmentClass() {

    }
}
