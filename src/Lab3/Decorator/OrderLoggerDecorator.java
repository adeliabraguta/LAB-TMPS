package Lab3.Decorator;

import Lab1.Orderable;
import Lab1.RestaurantService;

import java.util.List;

public class OrderLoggerDecorator implements RestaurantService {
    private final RestaurantService waiter;

    public OrderLoggerDecorator(RestaurantService waiter) {
        this.waiter = waiter;
    }

    @Override
    public void placeOrder(List<Orderable> items) {
        waiter.placeOrder(items);
        // Additional functionality: Logging the order
        System.out.println("Order logged: " + items);
    }
}
