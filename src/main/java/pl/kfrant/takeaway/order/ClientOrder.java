package pl.kfrant.takeaway.order;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.kfrant.takeaway.dish.Dish;

@Component
@SessionScope
public class ClientOrder {

    private Order order;

    public ClientOrder() {
        clear();
    }

    Order getOrder() {
        return order;
    }


    void add(Dish dish) {
        order.getDishes().add(dish);
    }

    void clear() {
        order = new Order();
        order.setStatus(OrderStatus.NEW);
    }
}
