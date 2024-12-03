import java.util.ArrayList;

public class SupplyCompany {

    // SupplyCompany fields
    protected ArrayList<Product> productsOffered = new ArrayList<>();
    protected ArrayList<Order> ordersReceived = new ArrayList<>();
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

    public void approveOrderStatus(Order order) {
        order.setStatus("Shipped");
        Delivery delivery = new Delivery(order, 1, "Shipped"); // id is 1 until we figure how to auto-increment
    }

    public void refuseOrderStatus(Order order) {
        order.setStatus("Cancelled");
    }

    public void receiveOrder(Order order) {
        ordersReceived.add(order);
    }

    public ArrayList<Order> getOrdersReceived() {
        return ordersReceived;
    }

    public void setOrdersReceived(ArrayList<Order> ordersReceived) {
        this.ordersReceived = ordersReceived;
    }
}
