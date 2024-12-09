package Products;

public class Product {

    // Products.Product fields
    private static String productID = "1";
    private static String name = Product.class.getName();
    private static String description = "The base of all Products. The \"OG\" Products.Product...";
    private static double unitPrice = 0; // Price per individual

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


    @Override
    public String toString() {
        return "[Products.Product Name: \"" + name + "\", ID: " + productID + ", Price: $" + unitPrice + "]";
    }

}
