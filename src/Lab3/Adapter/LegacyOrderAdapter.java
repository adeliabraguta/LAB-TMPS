package Lab3.Adapter;

import Lab1.Orderable;
import Lab1.TotalCalculator;

import java.util.List;

public class LegacyOrderAdapter implements TotalCalculator {
    private final LegacyOrderCalculator legacyOrderCalculator;

    public LegacyOrderAdapter(LegacyOrderCalculator legacyOrderCalculator) {
        this.legacyOrderCalculator = legacyOrderCalculator;
    }

    @Override
    public double calculateTotal(List<Orderable> items) {
        return legacyOrderCalculator.calculateLegacyTotal(items);
    }
}
