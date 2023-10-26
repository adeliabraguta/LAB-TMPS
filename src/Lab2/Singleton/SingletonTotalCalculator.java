package Lab2.Singleton;

import Lab1.Orderable;
import Lab1.TotalCalculator;
import Lab2.Builder.Order;

import java.util.List;

public class SingletonTotalCalculator implements TotalCalculator {
    private static SingletonTotalCalculator instance;

    // private constructor to prevent instantiation
    private SingletonTotalCalculator() {
    }

    public static SingletonTotalCalculator getInstance() {
        if (instance == null) {
            instance = new SingletonTotalCalculator();
        }
        return instance;
    }

    @Override
    public double calculateTotal(List<Orderable> items) {
        double total = 0;
        for (Orderable item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double calculateOrderTotal(Order order) {
        List<Orderable> items = order.getItems();
        return calculateTotal(items);
    }
}
