# Author: Braguta Adelia

----

# Topic: *SOLID PRINCIPLES*
## Objectives:


&ensp; &ensp; __1. Study and understand the SOLID Principles.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp;__3. Create a sample project that respects SOLID Principles.__

## Implementation

* Introduction

I made a small project that implements the working of a restaurant



* S -> Single Responsibility:

```
package Lab1;

public class Dish implements Orderable {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}


```

* O -> Open Close:

I have made the classes related to menu that can easily be extended without needing to dig into the inner workings of it

* L -> Liskov Substitution:
```
TotalCalculator totalCalculator = new SimpleTotalCalculator();
```

* I -> Interface Segregation:
```
package Lab1;

import java.util.List;

public interface TotalCalculator {
    double calculateTotal(List<Orderable> items);
}

package Lab1;

import java.util.List;

public interface RestaurantService {
    void placeOrder(List<Orderable> items);
}

package Lab1;

public interface Orderable {
    double getPrice();
    String getName();
}


```

* D -> Dependency Inversion:
```
RestaurantService waiter = new Waiter(totalCalculator);

```

## Conclusion
To sum up, I made the workings of Banking cards as Debit card where you just deposit money and then use it later, while
Credit card you get an initial sum of money you can use, but you have to pay back more. Also implemented the option to
transfer money from a card to another.
In my code I managed to implement somehow all SOLID principles and I learned all tactics used in the SOLID design principles.