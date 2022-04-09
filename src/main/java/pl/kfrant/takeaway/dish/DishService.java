package pl.kfrant.takeaway.dish;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDishes(){
        return dishRepository.findAll();
    }

    public Optional<Dish> getDishById(Long id){
        return dishRepository.findById(id);
    }




}
