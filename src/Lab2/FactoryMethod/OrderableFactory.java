package Lab2.FactoryMethod;

import Lab1.Orderable;

public interface OrderableFactory {
    Orderable createOrderable(String name, double price);
}
