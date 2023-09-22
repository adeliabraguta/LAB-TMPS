package Lab1;

import java.util.List;

public class SimpleTotalCalculator implements TotalCalculator {
    @Override
    public double calculateTotal(List<Orderable> items) {
        double total = 0;
        for (Orderable item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
