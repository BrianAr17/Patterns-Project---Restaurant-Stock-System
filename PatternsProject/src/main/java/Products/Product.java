package Products;

public class Product {

    // Products.Product fields
    private static String productID;
    private static String name;
    private static String description;
    private static double unitPrice; // Price per individual unit

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Product.description = description;
    }

    public static double getUnitPrice() {
        return unitPrice;
    }

    public static void setUnitPrice(double unitPrice) { Product.unitPrice = unitPrice; }

    public static String getProductID() {
        return productID;
    }

    public static String getName() { return name; }

    public static void setProductID(String productID) {
        Product.productID = productID;
    }

    public static void setName(String name) {
        Product.name = name;
    }

    public Product() {

    }

    @Override
    public String toString() {
        return "[Products.Product Name: \"" + name + "\", ID: " + productID + ", Price: $" + unitPrice + "]";
    }

}
