import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    // Order fields
    private String ID;
    private String status;
    private LocalDateTime dateSent;
    private LocalDateTime dateReceived;
    protected ArrayList<Product> products;
    private int quantity;

    public Order(String ID, ArrayList<Product> products) {
        this.ID = ID;
        this.status = "Pending";
        this.dateSent = LocalDateTime.now();
        this.dateReceived = null;
        this.products = products;
    }

    public String getStatus() {
        return status;
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
