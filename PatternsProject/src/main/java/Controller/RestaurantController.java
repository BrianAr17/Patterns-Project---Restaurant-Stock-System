package Controller;

import Model.Delivery;
import Model.Order;
import Model.Restaurant;
import Model.SupplyCompany;
import Products.Product;
import org.example.Database;


public class RestaurantController {

    private static RestaurantController instance = null;
    private Restaurant restaurant;

    private RestaurantController() {
        restaurant = new Restaurant("McDonald's","6045 rue Saint-Benoit","Montreal","Quebec","H4O 9M7","514-786-6424","mcdonaldisGood@gmail.com");
        restaurant.setOrdersSent(Database.fetchOrdersByStatus("Pending"));
        restaurant.setCancelledOrders(Database.fetchOrdersByStatus("Declined"));
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
    public void sendOrder(Order order, SupplyCompany company) {
        company.receiveOrder(order);
    }

    // Get the status of the specified order
    public String receiveOrderStatus(Order order) {
        String status = order.getStatus();
        return status;
    }

    public String receiveOrderInfo(int ID) {
        for (int i = 0 ; i < restaurant.ordersSent.size() ; i++) {
            if (restaurant.ordersSent.get(i).getID() == ID) {
                return restaurant.ordersSent.get(i).toString();
            }
        }
        return "No order information available at the moment for the specified order (Order ID = " + ID + ")\n";
    }

    // receive the info of all orders
    public String receiveAllOrderInfo() {
        String orderInfo = "";
        for (int i = 0 ; i < restaurant.ordersSent.size() ; i++) {
            orderInfo += restaurant.ordersSent.get(i).toString() + "\n";
        }
        if (orderInfo.isEmpty()) {
            return "There are no active orders at the moment\n";
        }
        else {
            return orderInfo;
        }
    }

    public String receiveDeliveryStatus(Delivery delivery) {
        String status = delivery.getStatus();
        return status;
    }

    public String receiveDeliveryInfo(SupplyCompany company, int deliveryID) {
        for (int i = 0 ; i < company.deliveries.size() ; i++) {
            if (company.deliveries.get(i).getDeliveryID() == deliveryID) {
                return company.deliveries.get(i).toString();
            }
        }
        return "No delivery information available at the moment for the specified delivery (Delivery ID = "  + deliveryID + ")\n";
    }

    public String receiveAllDeliveryInfo(SupplyCompany company) {
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
        return "Product Info:\n[Product Name: \"" + product.getName() + "\", ID: " + product.getProductID() + ", Description: " + product.getDescription() + ", Price: $" + product.getUnitPrice() + "]\n";
    }

    public String seeCancelledOrder(int ID) {
        for (int i = 0 ; i < restaurant.cancelledOrders.size() ; i++) {
            if (restaurant.cancelledOrders.get(i).getID() == ID) {
                return restaurant.cancelledOrders.get(i).toString();
            }
        }
        return "No order information available at the moment for the specified order (Order ID = "  + ID + ")\n";
    }

    public String seeAllCancelledOrders() {
        String orderInfo = "";
        for (int i = 0 ; i < restaurant.cancelledOrders.size() ; i++) {
            orderInfo += restaurant.cancelledOrders.get(i).toString() + "\n";
        }
        if (orderInfo.isEmpty())
        {
            return "No order has been cancelled\n";
        }
        else {
            return orderInfo;
        }
    }

    public String seeDeliveryReceived(int ID) {
        for (int i = 0 ; i < restaurant.deliveriesReceived.size() ; i++) {
            if (restaurant.deliveriesReceived.get(i).getDeliveryID() == ID) {
                return restaurant.deliveriesReceived.get(i).toString();
            }
        }
        return "No delivery information available at the moment for the specified delivery (Delivery ID = "  + ID + ")\n";
    }

    public String seeAllDeliveriesReceived() {
        String orderInfo = "";
        for (int i = 0 ; i < restaurant.deliveriesReceived.size() ; i++) {
            orderInfo += restaurant.deliveriesReceived.get(i).toString() + "\n";
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
