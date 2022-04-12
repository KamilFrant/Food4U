package pl.kfrant.takeaway.panel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kfrant.takeaway.dish.Dish;
import pl.kfrant.takeaway.order.Order;
import pl.kfrant.takeaway.order.OrderRepository;
import pl.kfrant.takeaway.order.OrderService;
import pl.kfrant.takeaway.order.OrderStatus;


import java.util.Optional;

@Controller()
public class PanelController {

    private final OrderService orderService;
    public PanelController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/panel/orders")
    public String getOrders(@RequestParam(required = false) OrderStatus status, Model model) {
        if (status == null) {
            model.addAttribute("orders", orderService.findAllOrders());
        } else {
            model.addAttribute("orders", orderService.findAllByStatus(status));
        }
        return "panel/orders";
    }

    @GetMapping("/panel/orders/{id}")
    public String showSingleOrder(@PathVariable Long id, Model model) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(o -> singleOrderPanel(o, model))
                .orElse("redirect:/");
    }

    @PostMapping("/panel/orders/{id}")
    public String changeOrderStatus(@PathVariable Long id, Model model) {
        Optional<Order> order = orderService.getOrderById(id);
        order.ifPresent(o -> {
            o.setStatus(OrderStatus.nextStatus(o.getStatus()));
            orderService.setNewStatus(o);
        });

        return order.map(o -> singleOrderPanel(o, model))
                .orElse("redirect:/");
    }

    private String singleOrderPanel(Order order, Model model) {
        model.addAttribute("order", order);
        model.addAttribute("sum", order.getDishes().stream().mapToDouble(Dish::getPrice).sum());
        return "panel/order";
    }
}
