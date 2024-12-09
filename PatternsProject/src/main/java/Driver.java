import Products.Product;

import java.util.HashMap;

public class Driver {
    public static void main(String[] args) {

        SupplyCompany company1 = new SupplyCompany(); // create a company
        company1.setName("A Generous Company");

        // Creating 4 products
        Product prod1 = new Product();

        // Adding the products to a products map
        HashMap<Product, Integer> products = new HashMap<>();
        products.put(prod1, 100);

        // Create Order
        Order order = new Order("1", products);

        // Send the order to Supply company
        Restaurant.sendOrder(order, company1);

        // Receive all active order information based on Order ID
        System.out.println(Restaurant.receiveOrderInfo("1"));
        System.out.println(Restaurant.receiveOrderInfo("2"));

        // Verify that company got order (if it displays, it means that it received the order)
        System.out.println(company1.ordersReceived.get(0));

        // Approve the order once received (I.E Shipping the order)
        company1.approveOrderStatus(company1.ordersReceived.get(0));

        // Verify the order and delivery status
        System.out.println(company1.deliveries.get(0).getOrder().getStatus());
        System.out.println(company1.deliveries.get(0).getStatus());

        // Receive delivery information based on Delivery ID
        System.out.println(Restaurant.receiveDeliveryInfo(company1, "1"));

        // Receive all delivery info of the specified company
        System.out.println(Restaurant.receiveAllDeliveryInfo(company1));

        // Receive all active order information based on Order ID
        System.out.println(Restaurant.receiveOrderInfo("1"));

        // Receive all active order info
        System.out.println(Restaurant.receiveAllOrderInfo());

        // Retrieve all the specified product information:
        System.out.println(Restaurant.getProductInfo(prod1));

        // See if any orders had been cancelled
        System.out.println(Restaurant.seeAllCancelledOrders());

        // See if there are any active orders
        System.out.println(Restaurant.receiveAllOrderInfo());

        // Time to ship the order
        company1.shipOrder("1");
        company1.shipOrder("2"); // test

        // See if there are any active orders
        System.out.println(Restaurant.receiveAllOrderInfo());

        // Receive all delivery info of the specified company
        System.out.println(Restaurant.receiveAllDeliveryInfo(company1));

        // Deliver the delivery to the restaurant
        company1.deliverOrder("1");
        company1.deliverOrder("2"); // test

        // See ongoing deliveries
        System.out.println(Restaurant.receiveAllDeliveryInfo(company1));

        // See all delivered deliveries
        System.out.println(Restaurant.seeDeliveryReceived("1"));
        System.out.println(Restaurant.seeDeliveryReceived("2")); // test

        System.out.println(Restaurant.seeAllDeliveriesReceived());

        // Verify that the order and delivery's delivery time has been set
        System.out.println(Restaurant.deliveriesReceived.get(0).getDateArrived());
        System.out.println(Restaurant.deliveriesReceived.get(0).getOrder().getDateReceived());
        System.out.println(Restaurant.deliveriesReceived.get(0).getOrder().getStatus());

        System.out.println();

        Storage storage = new Storage();
        storage.addProduct(new Delivery(order, "3", "Perfect", company1));

    }

    public static class PlaceholderProduct3 extends Product {

    }
}
