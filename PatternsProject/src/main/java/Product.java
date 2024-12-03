public class Product {

    // Product fields
    private static String description;
    private static double unitPrice;
    private static String productID;
    private String unitID;

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Product.description = description;
    }

    public static double getUnitPrice() {
        return unitPrice;
    }

    public static void setUnitPrice(double unitPrice) {
        Product.unitPrice = unitPrice;
    }

    public static String getProductID() {
        return productID;
    }

    public static void setProductID(String productID) {
        Product.productID = productID;
    }

    public String getUnitID() {
        return unitID;
    }

    public void setUnitID(String unitID) {
        this.unitID = unitID;
    }

}
