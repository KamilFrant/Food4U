package pl.kfrant.takeaway.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kfrant.takeaway.common.Message;
import pl.kfrant.takeaway.dish.Dish;
import pl.kfrant.takeaway.dish.DishService;

import java.util.Optional;

@Controller
public class OrderController {

    private final DishService dishService;
    private final ClientOrder clientOrder;
    private final OrderRepository orderRepository;

    public OrderController(DishService dishService, ClientOrder clientOrder, OrderRepository orderRepository) {
        this.dishService = dishService;
        this.clientOrder = clientOrder;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders/add")
    public String addDishToOrder(@RequestParam Long dishId, Model model){
        Optional<Dish> dish = dishService.getDishById(dishId);
        dish.ifPresent(clientOrder::add);
        if(dish.isPresent()) {
            model.addAttribute("message", new Message("Dodano", "Do zamówienia dodano: " + dish.get().getName()));
            model.addAttribute("order",clientOrder.getOrder());
            model.addAttribute("sum", clientOrder
                    .getOrder()
                    .getDishes().stream()
                    .mapToDouble(Dish::getPrice)
                    .sum());
        } else {
            model.addAttribute("message", new Message("Nie dodano", "Porano błędne id z menu: " + dishId));
        }
        return "order";
    }
    @GetMapping("/orders")
    public String getCurrentOrder(Model model) {
        model.addAttribute("order", clientOrder.getOrder());
        model.addAttribute("sum", clientOrder
                .getOrder()
                .getDishes().stream()
                .mapToDouble(Dish::getPrice)
                .sum());
        return "order";
    }
    @PostMapping("/orders/realize")
    public String proceedOrder(@RequestParam String address, @RequestParam String phoneNumber, Model model) {
        Order order = clientOrder.getOrder();
        order.setAddress(address);
        order.setPhoneNumber(phoneNumber);
        orderRepository.save(order);
        clientOrder.clear();
        model.addAttribute("order", clientOrder.getOrder());model.addAttribute("sum", clientOrder
                .getOrder()
                .getDishes().stream()
                .mapToDouble(Dish::getPrice)
                .sum());
        model.addAttribute("message", new Message("Dziękujemy", "Zamówienie przekazane do realizacji"));
        return "message";
    }

}
