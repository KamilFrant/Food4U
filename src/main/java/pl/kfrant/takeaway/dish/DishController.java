package pl.kfrant.takeaway.dish;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("dishes",dishService.getAllDishes());
        return "index";
    }

}
