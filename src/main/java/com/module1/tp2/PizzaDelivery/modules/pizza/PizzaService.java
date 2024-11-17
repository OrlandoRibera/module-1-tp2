package com.module1.tp2.PizzaDelivery.modules.pizza;

import com.module1.tp2.PizzaDelivery.modules.ingredient.Ingredient;
import com.module1.tp2.PizzaDelivery.modules.ingredient.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
  @Autowired
  private PizzaRepository pizzaRepository;
  @Autowired
  private IngredientService ingredientService;

  private final double minimumPizzaPrice = 20;

  public List<Pizza> getAllPizzas() {
    return (List<Pizza>) pizzaRepository.findAll();
  }

  public Optional<Pizza> getPizzaById(Long id) {
    return pizzaRepository.findById(id);
  }

  public Pizza createPizza(Pizza pizza) {
    double pizzaPrice = getPizzaPrice(pizza.getIngredients());
    pizza.setPrice(pizzaPrice);
    return pizzaRepository.save(pizza);
  }

  public Pizza createCustomPizza(List<Ingredient> ingredients) {
    double pizzaPrice = getPizzaPrice(ingredients);
    return pizzaRepository.save(new Pizza.PizzaBuilder().name("Custom Pizza").type("Custom").ingredients(ingredients).price(pizzaPrice).build());
  }

  public List<Pizza> createPizzas(List<Pizza> pizzas) {
    return (List<Pizza>) pizzaRepository.saveAll(pizzas);
  }

  private double getPizzaPrice(List<Ingredient> ingredients) {
    return ingredientService.getTotalPrice(ingredients) + minimumPizzaPrice;
  }
}
