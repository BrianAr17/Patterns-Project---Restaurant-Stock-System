package Model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private String city;
    private String province;
    private String zipcode;
    private String phoneNumber;
    private String email;
    public List<Order> ordersSent = new ArrayList<>();
    public List<Order> cancelledOrders = new ArrayList<>();
    public List<Delivery> deliveriesReceived = new ArrayList<>();

    public Restaurant(String name, String address, String city, String province, String zipCode, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.province = province;
        this.zipcode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setOrdersSent(List<Order> ordersSent) {
        this.ordersSent = ordersSent;
    }

    public void setCancelledOrders(List<Order> cancelledOrders) {
        this.cancelledOrders = cancelledOrders;
    }

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

}
