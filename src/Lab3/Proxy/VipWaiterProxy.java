package Lab3.Proxy;

import Lab1.Orderable;
import Lab1.RestaurantService;

import java.util.List;

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
