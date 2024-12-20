package Model;

import java.time.LocalDateTime;

public class Delivery {

    // Model.Delivery fields
    private Order order;
    private int deliveryID;
    private String status;
    private LocalDateTime dateShipped;
    private LocalDateTime dateArrived;
    private SupplyCompany company;

    public String getStatus() {
        return "Delivery Status: " + status + "\n";
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(LocalDateTime dateShipped) {
        this.dateShipped = dateShipped;
    }

    public LocalDateTime getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(LocalDateTime dateArrived) {
        this.dateArrived = dateArrived;
    }

    public SupplyCompany getCompany() {
        return company;
    }

    public void setCompany(SupplyCompany company) {
        this.company = company;
    }


    public Delivery(Order order, int deliveryID, String status, SupplyCompany company) {
        this.order = order;
        this.deliveryID = deliveryID;
        this.status = status;
        this.dateShipped = LocalDateTime.now();
        this.dateArrived = null;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Model.Delivery ID: " + deliveryID
                + "\nStatus: " + status
                + "\nDate Sent: " + dateShipped
                + "\nCompany: " + company.getName()
                + "\nModel.Order ID: " + order.getID()
                + "\n";
    }
}
