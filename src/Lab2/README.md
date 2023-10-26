# Topic: *Creational Design Patterns*

---

## Objectives:
&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some creational design patterns for object instantiation in a sample project.__

## Some Theory:
&ensp; &ensp; Creational design patterns are a category of design patterns that focus on the process of object creation.
They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the
specifics of object creation. Creational design patterns address common problems encountered in object creation, such as
how to create objects with different initialization parameters, how to create objects based on certain conditions, or how
to ensure that only a single instance of an object is created. There are several creational design patterns that have their
own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using
creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

#### Some examples of this kind of design patterns are:

* Singleton
* Builder
* Prototype
* Object Pooling
* Factory Method
* Abstract Factory

---

## Implementation

#### Introduction

I decided to implement Singleton, Builder, Prototype and Factory design principles.
I made some changes in restaurant system and added those principles.

#### Snippets from your files:

* Singleton Principle:

```java
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
}
```
* Prototype Principle:

```java
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

```
* Builder Principle:

```java
public class OrderBuilder {
    private Order order;

    public OrderBuilder(Customer customer) {
        this.order = new Order(customer);
    }

    public OrderBuilder addItem(Orderable item) {
        order.addItem(item);
        return this;
    }

    public Order build() {
        return order;
    }
}

```
* Factory Principle:

```java
public interface OrderableFactory {
    Orderable createOrderable(String name, double price);
}
public class DishFactory implements OrderableFactory{
    @Override
    public Orderable createOrderable(String name, double price) {
        return new Dish(name, price);
    }
}
public class DrinkFactory implements OrderableFactory{
    @Override
    public Orderable createOrderable(String name, double price) {
        return new Dish(name, price);
    }
}
```

## Conclusion

I've successfully applied four creational design patterns in my code. This practical approach has deepened my understanding
of these design patterns and how they can be effectively utilized in software development. Overall, it's been a rewarding
experience that enhances my grasp of creational design patterns.