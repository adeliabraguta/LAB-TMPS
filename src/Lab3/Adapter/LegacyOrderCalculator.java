package Lab3.Adapter;

import Lab1.Orderable;

import java.util.List;

public class LegacyOrderCalculator {
    public double calculateLegacyTotal(List<Orderable> items) {
        double total = 0;
        double tax = 0;
        for (Orderable item : items) {
            tax = item.getPrice() / 0.22;
            total += item.getPrice() * 1.2 + tax;
        }
        return total;
    }
}
