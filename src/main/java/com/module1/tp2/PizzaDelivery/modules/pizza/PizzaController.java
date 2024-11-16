package com.module1.tp2.PizzaDelivery.modules.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

  @Autowired
  private PizzaService pizzaService;

  @GetMapping("/getAll")
  public List<Pizza> getAllPizzas() {
    return pizzaService.getAllPizzas();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
    return pizzaService.getPizzaById(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public Pizza createPizza(@RequestBody Pizza pizza) {
    return pizzaService.createPizza(pizza);
  }

  @PostMapping("/createInBulk")
  public List<Pizza> createPizzas(@RequestBody List<Pizza> pizzas) {
    return pizzaService.createPizzas(pizzas);
  }

}
