package pl.kfrant.takeaway.panel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kfrant.takeaway.order.OrderService;
import pl.kfrant.takeaway.order.OrderStatus;

@Controller()
public class PanelController {

    private final OrderService orderService;

    public PanelController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/panel/orders")
    public String getOrders(@RequestParam(required = false)OrderStatus status, Model model){
        if(status==null){
            model.addAttribute("orders",orderService.findAllOrders());
        }else {
            model.addAttribute("orders",orderService.findAllByStatus(status));
        }
        return "panel/orders";
    }
}
