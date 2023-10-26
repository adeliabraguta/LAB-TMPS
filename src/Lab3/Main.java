package Lab3;

import Lab1.*;
import Lab2.Builder.Customer;
import Lab2.Builder.Order;
import Lab2.Builder.OrderBuilder;
import Lab3.Adapter.LegacyOrderAdapter;
import Lab3.Adapter.LegacyOrderCalculator;
import Lab3.Composite.Menu;
import Lab3.Decorator.OrderLoggerDecorator;
import Lab3.Proxy.VipWaiterProxy;

public class Main {
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("John Doe");

        // Use the Adapter pattern to adapt LegacyOrderCalculator to TotalCalculator
        LegacyOrderCalculator legacyOrderCalculator = new LegacyOrderCalculator();
        TotalCalculator adaptedCalculator = new LegacyOrderAdapter(legacyOrderCalculator);

        // Use the Decorator pattern to add logging functionality to the Waiter
        Waiter basicWaiter = new Waiter(adaptedCalculator);
        RestaurantService decoratedWaiter = new OrderLoggerDecorator(basicWaiter);

        // Use the Proxy pattern to control access to the decorated Waiter for VIP customers
        RestaurantService vipWaiter = new VipWaiterProxy(decoratedWaiter, true);

        // Use the Composite pattern to create a menu with individual dishes and a submenu
        Menu mainMenu = new Menu("Main Menu");
        mainMenu.addItem(new Dish("Spaghetti", 12.99));
        mainMenu.addItem(new Drink("Soda", 2.49));

        Menu specialMenu = new Menu("Special Menu");
        specialMenu.addItem(new Dish("Special Dish", 19.99));
        specialMenu.addItem(new Drink("Special Drink", 5.99));

        mainMenu.addItem(specialMenu);

        // Create an order with items from the main menu
        OrderBuilder orderBuilder = new OrderBuilder(customer);
        Order order = orderBuilder
                .addItem(mainMenu)
                .build();

        // Place the order using the VIP waiter
        vipWaiter.placeOrder(order.getItems());
    }
}
