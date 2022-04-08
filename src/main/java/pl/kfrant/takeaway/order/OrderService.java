package pl.kfrant.takeaway.order;

import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import pl.kfrant.takeaway.dish.Dish;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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


    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id){
        return orderRepository.findById(id);
    }

    public List<Order> findAllByStatus(OrderStatus status){
        return orderRepository.findAllByStatus(status);
    }

    @Transactional
    public Order setNewStatus(Order order){
        Order orderEdited = orderRepository.getById(order.getId());
        orderEdited.setStatus(order.getStatus());
        return orderEdited;
    }
}