package Lab2.Prototype;

import Lab1.Dish;
import Lab1.Drink;
import Lab1.Orderable;

public class CloneOrder implements OrderablePrototype {

    @Override
    public Orderable cloneDish(Dish dish) {
        return new Dish(dish.getName(), dish.getPrice());
    }

    @Override
    public Orderable cloneDrink(Drink drink) {
        return new Drink(drink.getName(), drink.getPrice());
    }

    @Override
    public Orderable cloneOrderable(Orderable orderable) {
        if (orderable instanceof Dish) {
            return cloneDish((Dish) orderable);
        } else if (orderable instanceof Drink) {
            return cloneDrink((Drink) orderable);
        }
        return null;
    }
}
