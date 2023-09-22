package Lab1;

import java.util.List;

public class Waiter implements RestaurantService {
    private TotalCalculator totalCalculator;

    public Waiter(TotalCalculator totalCalculator) {
        this.totalCalculator = totalCalculator;
    }

    @Override
    public void placeOrder(List<Orderable> items) {
        // Place an order and calculate the total cost
        double totalCost = totalCalculator.calculateTotal(items);
        System.out.println("Order placed. Total cost: $" + totalCost);
    }
}
