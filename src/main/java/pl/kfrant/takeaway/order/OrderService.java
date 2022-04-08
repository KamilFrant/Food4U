package pl.kfrant.takeaway.order;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import pl.kfrant.takeaway.dish.Dish;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Double sumOrderPrice(ClientOrder clientOrder){
        return clientOrder
                .getOrder()
                .getDishes().stream()
                .mapToDouble(Dish::getPrice)
                .sum();
    }

}