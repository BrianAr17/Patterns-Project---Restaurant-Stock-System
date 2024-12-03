import java.time.LocalDateTime;
import java.util.Date;

public class Delivery {

    // Delivery fields
    private Order order;
    private int deliveryID;
    private String status;
    private LocalDateTime dateShipped;
    private LocalDateTime dateArrived;

    public String getStatus() {
        return status;
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

    public Delivery(Order order, int deliveryID, String status) {
        this.order = order;
        this.deliveryID = deliveryID;
        this.status = status;
        this.dateShipped = LocalDateTime.now();
        this.dateArrived = null;
    }
}
