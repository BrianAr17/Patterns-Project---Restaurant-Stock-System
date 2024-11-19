import java.util.ArrayList;

public class SupplyCompany {

    // SupplyCompany fields
    protected ArrayList<Product> productsOffered;
    private String name;

    public ArrayList<Product> getProductsOffered() {
        return productsOffered;
    }

    public void setProductsOffered(ArrayList<Product> productsOffered) {
        this.productsOffered = productsOffered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void approveOrderStatus(Order order) {
        order.setStatus("Shipped");
        Delivery delivery = new Delivery(order, 1, "Shipped"); // id is 1 until we figure how to auto-increment
    }

    private void refuseOrderStatus(Order order) {
        order.setStatus("Cancelled");
    }

}
