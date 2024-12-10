package Model;

import Products.Product;
import java.util.ArrayList;

public class Restaurant {

    // Model.Restaurant fields

    private static String name;
    private static String address;
    private static String city;
    private static String province;
    private static String zipcode;
    private static String phoneNumber;
    private static String email;
    public static ArrayList<Order> ordersSent = new ArrayList<>();
    public static ArrayList<Order> cancelledOrders = new ArrayList<>();
    public static ArrayList<Delivery> deliveriesReceived = new ArrayList<>();

    private Restaurant(){

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
