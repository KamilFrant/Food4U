package pl.kfrant.takeaway.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kfrant.takeaway.dish.DishService;

@Controller("/")
public class HomeController {

    private final DishService dishService;

    public HomeController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("dishes",dishService.getAllDishes());
        return "index";
    }
}
