# Topic: *Structural Design Patterns*

---

## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__

## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Some examples of from this category of design patterns are:

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy

---

## Implementation

#### Introduction

I decided to implement Adapter, Composite, Decorator and Proxy design patterns.
I created a java program where my previous base classed of Restaurent implement all this patterns.


#### Snippets from your files:

* Adapter:

```java
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
```

* Composite:

```java
public class Menu implements Orderable {
    private String name;
    private List<Orderable> items;

    public Menu(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(Orderable item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Orderable item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder menuString = new StringBuilder(name + ": [");
        for (Orderable item : items) {
            menuString.append(item.getName()).append(", ");
        }
        if (!items.isEmpty()) {
            menuString.delete(menuString.length() - 2, menuString.length()); // Remove the last comma and space
        }
        menuString.append("]");
        return menuString.toString();
    }
}
```

* Decorator:

```java
public class OrderLoggerDecorator implements RestaurantService {
    private final RestaurantService waiter;

    public OrderLoggerDecorator(RestaurantService waiter) {
        this.waiter = waiter;
    }

    @Override
    public void placeOrder(List<Orderable> items) {
        waiter.placeOrder(items);
        // Additional functionality: Logging the order
        System.out.println("Order logged: " + items);
    }
}

```

* Proxy:

```java
public class VipWaiterProxy implements RestaurantService {
    private RestaurantService waiter;
    private boolean isVip;

    public VipWaiterProxy(RestaurantService waiter, boolean isVip) {
        this.waiter = waiter;
        this.isVip = isVip;
    }

    @Override
    public void placeOrder(List<Orderable> items) {
        if (isVip) {
            waiter.placeOrder(items);
            System.out.println("Special treatment for VIP customer!");
        } else {
            System.out.println("Sorry, this service is reserved for VIP customers.");
        }
    }
}
```

Finally, in the Main class from Package "Lab3" is shown how everything works

## Conclusion
To sum up, I have created a simple code that implements some structural design patterns of my choosing.
In my code I managed to fit somehow 4 structural design patterns. Moreover, I managed not only to create and use them,
but also to interconnect them. That's why I think I have understood the structural design patterns main purpose.