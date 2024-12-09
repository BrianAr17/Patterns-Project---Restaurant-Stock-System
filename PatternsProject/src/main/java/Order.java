import Products.Product;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Order {

    // Order fields
    private String ID;
    private String status;
    private LocalDateTime dateSent;
    private LocalDateTime dateReceived;
    private HashMap<Product, Integer> order;

    public Order(String ID, HashMap<Product, Integer> order) {
        this.ID = ID;
        this.status = "Pending";
        this.dateSent = LocalDateTime.now();
        this.dateReceived = null;
        this.order = order;
    }

    public String getStatus() {
        return "Order Status: " + status + "\n";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDateTime dateSent) {
        this.dateSent = dateSent;
    }

    public LocalDateTime getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDateTime dateReceived) {
        this.dateReceived = dateReceived;
    }

    public HashMap<Product, Integer> getOrder() {
        return order;
    }

    public void setOrder(HashMap<Product, Integer> order) {
        this.order = order;
    }

    @Override
    public String toString() {

        return "Order ID: " + ID
                + "\nStatus: " + status
                + "\nDate Sent: " + dateSent
                + "\nProducts and quantities: " + order.toString()
                + "\n";

    }

}
