package Model;

import Products.Product;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Order {

    // Model.Order fields
    private int ID;
    private String status;
    private LocalDate dateSent;
    private LocalDate dateReceived;
    private HashMap<Product, Integer> order;

    public Order(int ID, HashMap<Product, Integer> order) {
        this.ID = ID;
        this.status = "Pending";
        this.dateSent = LocalDate.now();
        this.dateReceived = null;
        this.order = order;
    }

    public String getStatus() {
        return "Order Status: " + status + "\n";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
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
