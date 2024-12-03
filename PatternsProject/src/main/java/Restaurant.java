import java.util.ArrayList;

public class Restaurant {

    // Restaurant fields
    private String name;
    private String address;
    private String city;
    private String province;
    private String zipcode;
    private String phoneNumber;
    private String email;
    protected static ArrayList<Order> ordersSent = new ArrayList<>();
    protected static ArrayList<Order> deliveriesShipped = new ArrayList<>();

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

    public void receiveOrder(Delivery delivery) {
        delivery.setStatus("Delivered");
        deliveriesShipped.forEach(order -> {
            if (order.getStatus().equals("Delivered")) {
                deliveriesShipped.remove(order);
            }
        });
    }

    public void sendOrder(Order order, SupplyCompany company) {

        ordersSent.add(order);
        company.ordersReceived.add(order);

    }

    public String receiveOrderStatus(Order order) {
        String status = order.getStatus();
        return status;
    }

    public String receiveAllOrderInfo() {
        return ordersSent.toString();
    }

    public String receiveDeliveryStatus(Delivery delivery) {
        String status = delivery.getStatus();
        return status;
    }

    public String receiveAllDeliveryInfo() {
        return deliveriesShipped.toString();
    }

}
