import Lab1.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Liskov Substitution
        TotalCalculator totalCalculator = new SimpleTotalCalculator();

        // Dependency injection of TotalCalculator into Waiter
        RestaurantService waiter = new Waiter(totalCalculator);

        // Creating orderable items
        List<Orderable> items = new ArrayList<>();
        items.add(new Dish("Spaghetti Carbonara", 12.99));
        items.add(new Dish("Steak", 24.99));
        items.add(new Drink("Red Wine", 8.99));
        items.add(new Drink("Espresso", 3.49));

        // Placing an order
        waiter.placeOrder(items);
    }
}