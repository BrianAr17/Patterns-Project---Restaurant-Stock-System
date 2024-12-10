package Products;

public class Product {
    private int productID;
    private String name;
    private String description;
    private double unitPrice; // Price per individual unit

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Products.Product Name: \"" + name + "\", ID: " + productID + ", Price: $" + unitPrice + "]";
    }

}
