package com.module1.tp2.PizzaDelivery.modules.order;

import com.module1.tp2.PizzaDelivery.modules.ingredient.Ingredient;
import com.module1.tp2.PizzaDelivery.modules.ingredient.IngredientService;
import com.module1.tp2.PizzaDelivery.modules.order.dto.OrderRequest;
import com.module1.tp2.PizzaDelivery.modules.pizza.Pizza;
import com.module1.tp2.PizzaDelivery.modules.pizza.PizzaFactory;
import com.module1.tp2.PizzaDelivery.modules.pizza.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private PizzaService pizzaService;
  @Autowired
  private IngredientService ingredientService;

  public List<Order> getAll() {
    return (List<Order>) orderRepository.findAll();
  }

  public Order create(OrderRequest orderRequest) {
    List<Pizza> pizzas = new ArrayList<>();
    for (Pizza pizzaFromRequest : orderRequest.getPizzas()) {
      if (pizzaFromRequest.getIngredients() != null && pizzaFromRequest.getIngredients().size() > 0) {
        // Create custom pizza
        List<Long> ingredientIds = pizzaFromRequest.getIngredients().stream().map(Ingredient::getId).toList();
        List<Ingredient> ingredients = ingredientService.getIngredientsById(ingredientIds);
        pizzas.add(pizzaService.createCustomPizza(ingredients));
      } else {
        // Create pressed pizza
        Pizza pressedPizza = PizzaFactory.createPizza(pizzaFromRequest.getName());
        if (pressedPizza == null) {
          break;
        }
        List<Ingredient> ingredientsFromDatabase = new ArrayList<>();
        for (Ingredient ingredient : pressedPizza.getIngredients()) {
          Ingredient foundIngredient = ingredientService.getIngredientByName(ingredient.getName());
          ingredientsFromDatabase.add(foundIngredient);
        }
        pressedPizza.setType("Pressed");
        pressedPizza.setIngredients(ingredientsFromDatabase);
        pizzas.add(pizzaService.createPizza(pressedPizza));
      }
    }

    // TODO: Aplicar promociones

    // Crear la orden
    Order order = new Order();
    order.setOrderDate(LocalDateTime.now());
    order.setPizzas(pizzas);
    order.setDeliveryAddress(orderRequest.getDeliveryAddress());
    order.setDeliveryPrice(15D);
    order.setClientName(orderRequest.getClientName());
    return orderRepository.save(order);
  }
}
