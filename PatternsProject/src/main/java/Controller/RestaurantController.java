package Controller;

import Model.Delivery;
import Model.Order;
import Model.Restaurant;
import Model.SupplyCompany;
import Products.Product;

public class RestaurantController {

    private static RestaurantController instance = null;

    private RestaurantController() {

    }

    public static RestaurantController Instance(){
        if (instance == null){
            return new RestaurantController();
        }
        else{
            return instance;
        }
    }

    public static void createOrder() {

    }


    // Sends order to the company
    public static void sendOrder(Order order, SupplyCompany company) {
        company.receiveOrder(order);
    }

    // Get the status of the specified order
    public static String receiveOrderStatus(Order order) {
        String status = order.getStatus();
        return status;
    }

    public static String receiveOrderInfo(String ID) {
        for (int i = 0 ; i < Restaurant.ordersSent.size() ; i++) {
            if (Restaurant.ordersSent.get(i).getID().equals(ID)) {
                return Restaurant.ordersSent.get(i).toString();
            }
        }
        return "No order information available at the moment for the specified order (Order ID = " + ID + ")\n";
    }

    // receive the info of all orders
    public static String receiveAllOrderInfo() {
        String orderInfo = "";
        for (int i = 0 ; i < Restaurant.ordersSent.size() ; i++) {
            orderInfo += Restaurant.ordersSent.get(i).toString() + "\n";
        }
        if (orderInfo.isEmpty()) {
            return "There are no active orders at the moment\n";
        }
        else {
            return orderInfo;
        }
    }

    public static String receiveDeliveryStatus(Delivery delivery) {
        String status = delivery.getStatus();
        return status;
    }

    public static String receiveDeliveryInfo(SupplyCompany company, String deliveryID) {
        for (int i = 0 ; i < company.deliveries.size() ; i++) {
            if (company.deliveries.get(i).getDeliveryID().equals(deliveryID)) {
                return company.deliveries.get(i).toString();
            }
        }
        return "No delivery information available at the moment for the specified delivery (Delivery ID = "  + deliveryID + ")\n";
    }

    public static String receiveAllDeliveryInfo(SupplyCompany company) {
        String deliveryInfo = "";
        for (int i = 0 ; i < company.deliveries.size() ; i++) {
            deliveryInfo += company.deliveries.get(i).toString();
        }
        if (deliveryInfo.isEmpty()) {
            return "There are no active deliveries at the moment\n";
        }
        else {
            return deliveryInfo;
        }
    }

    public static String getProductInfo(Product product) {
        return "Product Info:\n[Product Name: \"" + Product.getName() + "\", ID: " + Product.getProductID() + ", Description: " + Product.getDescription() + ", Price: $" + Product.getUnitPrice() + "]\n";
    }

    public static String seeCancelledOrder(String ID) {
        for (int i = 0 ; i < Restaurant.cancelledOrders.size() ; i++) {
            if (Restaurant.cancelledOrders.get(i).getID().equals(ID)) {
                return Restaurant.cancelledOrders.get(i).toString();
            }
        }
        return "No order information available at the moment for the specified order (Order ID = "  + ID + ")\n";
    }

    public static String seeAllCancelledOrders() {
        String orderInfo = "";
        for (int i = 0 ; i < Restaurant.cancelledOrders.size() ; i++) {
            orderInfo += Restaurant.cancelledOrders.get(i).toString() + "\n";
        }
        if (orderInfo.isEmpty())
        {
            return "No order has been cancelled\n";
        }
        else {
            return orderInfo;
        }
    }

    public static String seeDeliveryReceived(String ID) {
        for (int i = 0 ; i < Restaurant.deliveriesReceived.size() ; i++) {
            if (Restaurant.deliveriesReceived.get(i).getDeliveryID().equals(ID)) {
                return Restaurant.deliveriesReceived.get(i).toString();
            }
        }
        return "No delivery information available at the moment for the specified delivery (Delivery ID = "  + ID + ")\n";
    }

    public static String seeAllDeliveriesReceived() {
        String orderInfo = "";
        for (int i = 0 ; i < Restaurant.deliveriesReceived.size() ; i++) {
            orderInfo += Restaurant.deliveriesReceived.get(i).toString() + "\n";
        }
        if (orderInfo.isEmpty())
        {
            return "No delivery has been delivered\n";
        }
        else {
            return orderInfo;
        }
    }

    public static void removeOrder(Order order, SupplyCompany company) {
        company.cancelOrder(order);
    }
}
