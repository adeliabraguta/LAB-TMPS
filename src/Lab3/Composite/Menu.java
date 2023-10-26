package Lab3.Composite;

import Lab1.Orderable;

import java.util.ArrayList;
import java.util.List;

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
