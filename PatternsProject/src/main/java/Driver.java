import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        SupplyCompany company1 = new SupplyCompany();

        // Creating 4 products
        Product prod1 = new Product();
        Product prod2 = new Product();
        Product prod3 = new Product();
        Product prod4 = new Product();

        // Adding the products to a products list
        ArrayList<Product> productsForOrder1 = new ArrayList<Product>();

        // Creating a new order
        Order order = new Order("1", productsForOrder1);

        // Send the order to Supply company
        restaurant.sendOrder(order, company1);

        // Verify that company got order
        System.out.println(company1.ordersReceived);

        // Approve the order once received
        company1.approveOrderStatus(company1.ordersReceived.get(0));
        // Verify the order status
        System.out.println(company1.ordersReceived.get(0).getStatus());



    }
}
