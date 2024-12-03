import java.util.ArrayList;
import java.util.TreeMap;

public class Restaurant {

    // Restaurant fields
    private static String name;
    private static String address;
    private static String city;
    private static String province;
    private static String zipcode;
    private static String phoneNumber;
    private static String email;
    protected static ArrayList<Order> ordersSent = new ArrayList<>();
    protected static ArrayList<Order> cancelledOrders = new ArrayList<>();
    protected static ArrayList<Delivery> deliveriesReceived = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        for (int i = 0 ; i < ordersSent.size() ; i++) {
            if (ordersSent.get(i).getID().equals(ID)) {
                return ordersSent.get(i).toString();
            }
        }
        return "No order information available at the moment for the specified order (Order ID = " + ID + ")\n";
    }

    // receive the info of all orders
    public static String receiveAllOrderInfo() {
        String orderInfo = "";
        for (int i = 0 ; i < ordersSent.size() ; i++) {
            orderInfo += ordersSent.get(i).toString() + "\n";
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
        for (int i = 0 ; i < cancelledOrders.size() ; i++) {
            if (cancelledOrders.get(i).getID().equals(ID)) {
                return cancelledOrders.get(i).toString();
            }
        }
        return "No order information available at the moment for the specified order (Order ID = "  + ID + ")\n";
    }

    public static String seeAllCancelledOrders() {
        String orderInfo = "";
        for (int i = 0 ; i < cancelledOrders.size() ; i++) {
            orderInfo += cancelledOrders.get(i).toString() + "\n";
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
        for (int i = 0 ; i < deliveriesReceived.size() ; i++) {
            if (deliveriesReceived.get(i).getDeliveryID().equals(ID)) {
                return deliveriesReceived.get(i).toString();
            }
        }
        return "No delivery information available at the moment for the specified delivery (Delivery ID = "  + ID + ")\n";
    }

    public static String seeAllDeliveriesReceived() {
        String orderInfo = "";
        for (int i = 0 ; i < deliveriesReceived.size() ; i++) {
            orderInfo += deliveriesReceived.get(i).toString() + "\n";
        }
        if (orderInfo.isEmpty())
        {
            return "No delivery has been delivered\n";
        }
        else {
            return orderInfo;
        }
    }

}
