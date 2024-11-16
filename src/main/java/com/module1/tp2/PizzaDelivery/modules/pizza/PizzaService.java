package com.module1.tp2.PizzaDelivery.modules.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
  @Autowired
  private PizzaRepository pizzaRepository;

  public List<Pizza> getAllPizzas() {
    return (List<Pizza>) pizzaRepository.findAll();
  }

  public Optional<Pizza> getPizzaById(Long id) {
    return pizzaRepository.findById(id);
  }

  public Pizza createPizza(Pizza pizza) {
    return pizzaRepository.save(pizza);
  }

  public List<Pizza> createPizzas(List<Pizza> pizzas) {
    return (List<Pizza>) pizzaRepository.saveAll(pizzas);
  }
}
