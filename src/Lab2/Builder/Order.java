package Lab2.Builder;

import Lab1.Orderable;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Orderable> items;
    private final Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Orderable item) {
        items.add(item);
    }

    public List<Orderable> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }
}
