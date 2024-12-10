package Model;

import Products.Product;
import org.example.Database;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SupplyCompany {

    // Model.SupplyCompany fields
    public ArrayList<Product> productsOffered = new ArrayList<>();
    public ArrayList<Order> ordersReceived = new ArrayList<>();
    public ArrayList<Delivery> deliveries = new ArrayList<>();
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

    // Custom Methods
    public void approveOrderStatus(Order order) {
        order.setStatus("Approved");
        Delivery delivery = new Delivery(order, order.getID(), "Preparing Order", this); // ID is 1 until we figure how to auto-increment
        this.deliveries.add(delivery);
    }

    public void refuseOrderStatus(Order order) {
        cancelOrder(order);
    }

    public void receiveOrder(Order order) {
        Restaurant.ordersSent.add(order);
        ordersReceived.add(order);
    }

    public void shipOrder(String deliveryID) {
        boolean found = false;
        for (int i = 0 ; i < deliveries.size() ; i++) { // works as long as the order ID is equal to the delivery ID
            if (deliveries.get(i).getDeliveryID().equals(deliveryID)) {
                Order order = deliveries.get(i).getOrder();
                deliveries.get(i).setStatus("Shipped");
                order.setStatus("Shipped");
                Restaurant.ordersSent.remove(order);
                this.ordersReceived.remove(order);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Could not find order to ship (Delivery ID = " + deliveryID + ")\n");
        }
    }

    public void cancelOrder(Order order) {
        Restaurant.ordersSent.remove(order);
        this.ordersReceived.remove(order);
        order.setStatus("Cancelled");
        Restaurant.cancelledOrders.add(order);
        System.out.println("Attention!\nThe order of ID = " + order.getID() + " was cancelled by " + this.getName() + "\n");
    }

    public void deliverOrder(String deliveryID) {
        boolean found = false;
        for (int i = 0 ; i < deliveries.size() ; i++) { // works as long as the order ID is equal to the delivery ID
            if (deliveries.get(i).getDeliveryID().equals(deliveryID)) {
                Order order = deliveries.get(i).getOrder();
                order.setDateReceived(LocalDateTime.now());
                deliveries.get(i).setStatus("Delivered");
                deliveries.get(i).setDateArrived(LocalDateTime.now());
                order.setStatus("Delivered");
                Restaurant.deliveriesReceived.add(deliveries.get(i));
                Storage.addProduct(deliveries.get(i));

                Database.fullInsertOrder(order);

                HashMap<Product, Integer> map = order.getOrder(); // getting the hashmap value
                for (Map.Entry<Product, Integer> entry : map.entrySet()) {
                    Database.insertIntoReceiptTable(Integer.parseInt(order.getID()), map.get(entry.getKey()), map.get(entry.getValue()));
                }

                deliveries.remove(deliveries.get(i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Could not find order to deliver (Delivery ID = " + deliveryID + ")\n");
        }
    }

}
