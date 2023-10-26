package Lab2.Builder;

import Lab1.Orderable;

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
