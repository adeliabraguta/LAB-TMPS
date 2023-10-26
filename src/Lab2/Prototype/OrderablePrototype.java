package Lab2.Prototype;

import Lab1.Dish;
import Lab1.Drink;
import Lab1.Orderable;

public interface OrderablePrototype extends Cloneable {
    Orderable cloneDish(Dish dish);
    Orderable cloneDrink(Drink drink);
    Orderable cloneOrderable(Orderable orderable);
}
