package Lab2;

import Lab1.Dish;
import Lab1.Drink;
import Lab1.Orderable;
import Lab2.Builder.Customer;
import Lab2.Builder.Order;
import Lab2.Builder.OrderBuilder;
import Lab2.FactoryMethod.DishFactory;
import Lab2.FactoryMethod.DrinkFactory;
import Lab2.FactoryMethod.OrderableFactory;
import Lab2.Prototype.CloneOrder;
import Lab2.Singleton.SingletonTotalCalculator;

public class Main {
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("John Doe");

        // Use the Builder pattern to create an order
        OrderBuilder orderBuilder = new OrderBuilder(customer);
        Order order = orderBuilder
                .addItem(new Dish("Spaghetti", 12.99))
                .addItem(new Drink("Soda", 2.49))
                .addItem(new Dish("Salad", 8.99))
                .build();

        // Use the Factory Method pattern to create items
        OrderableFactory dishFactory = new DishFactory();
        OrderableFactory drinkFactory = new DrinkFactory();

        Orderable specialDish = dishFactory.createOrderable("Special Dish", 19.99);
        Orderable specialDrink = drinkFactory.createOrderable("Special Drink", 5.99);

        // Add special items to the order
        order.addItem(specialDish);
        order.addItem(specialDrink);

        // Use the Prototype pattern to clone items
        CloneOrder cloneOrder = new CloneOrder();
        Orderable clonedSpecialDish = cloneOrder.cloneOrderable(specialDish);
        Orderable clonedSpecialDrink = cloneOrder.cloneOrderable(specialDrink);

        // Add cloned items to the order
        order.addItem(clonedSpecialDish);
        order.addItem(clonedSpecialDrink);

        // Print the order details
        System.out.println("Order for " + order.getCustomer().getName());
        for (Orderable item : order.getItems()) {
            System.out.println(item.getName() + ": $" + item.getPrice());
        }

        // Calculate and print the total using the SingletonTotalCalculator
        SingletonTotalCalculator totalCalculator = SingletonTotalCalculator.getInstance();
        System.out.println(totalCalculator.hashCode());
        SingletonTotalCalculator newTotalCalculator = SingletonTotalCalculator.getInstance();
        System.out.println(newTotalCalculator.hashCode());
        
        double orderTotal = totalCalculator.calculateOrderTotal(order);
        System.out.println("Order total: $" + orderTotal);
    }
}


