package Lab2.FactoryMethod;

import Lab1.Dish;
import Lab1.Orderable;

public class DishFactory implements OrderableFactory{
    @Override
    public Orderable createOrderable(String name, double price) {
        return new Dish(name, price);
    }
}
