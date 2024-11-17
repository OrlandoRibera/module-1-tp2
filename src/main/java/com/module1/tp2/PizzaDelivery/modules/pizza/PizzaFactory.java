package com.module1.tp2.PizzaDelivery.modules.pizza;

import com.module1.tp2.PizzaDelivery.modules.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PizzaFactory {
  private static List<Ingredient> margaritaIngredients;
  private static List<Ingredient> carbonaraIngredients;
  private static List<Ingredient> hawaianaIngredients;
  private static List<Ingredient> pepperoniIngredients;

  public PizzaFactory() {
    _setupDefaultIngredients();
  }

  public static Pizza createPizza(String type) {
    _setupDefaultIngredients();
    return switch (type.toLowerCase()) {
      case "margarita" -> new Pizza.PizzaBuilder().name("Margarita").ingredients(margaritaIngredients).build();
      case "carbonara" -> new Pizza.PizzaBuilder().name("Margarita").ingredients(carbonaraIngredients).build();
      case "hawaiana" -> new Pizza.PizzaBuilder().name("Hawaiana").ingredients(hawaianaIngredients).build();
      case "pepperoni" -> new Pizza.PizzaBuilder().name("Pepperoni").ingredients(pepperoniIngredients).build();
      default -> null;
    };
  }

  private static void _setupDefaultIngredients() {
    margaritaIngredients = new ArrayList<>();
    margaritaIngredients.add(new Ingredient("Tomato Sauce"));
    margaritaIngredients.add(new Ingredient("Mozzarella"));
    margaritaIngredients.add(new Ingredient("Pepperoni"));
    margaritaIngredients.add(new Ingredient("Cheese"));
    margaritaIngredients.add(new Ingredient("Oregano"));

    carbonaraIngredients = new ArrayList<>();
    carbonaraIngredients.add(new Ingredient("Tomato Sauce"));
    carbonaraIngredients.add(new Ingredient("Mozzarella"));
    carbonaraIngredients.add(new Ingredient("Pepperoni"));
    carbonaraIngredients.add(new Ingredient("Cheese"));
    carbonaraIngredients.add(new Ingredient("Oregano"));

    hawaianaIngredients = new ArrayList<>();
    hawaianaIngredients.add(new Ingredient("Tomato Sauce"));
    hawaianaIngredients.add(new Ingredient("Mozzarella"));
    hawaianaIngredients.add(new Ingredient("Pepperoni"));
    hawaianaIngredients.add(new Ingredient("Cheese"));
    hawaianaIngredients.add(new Ingredient("Oregano"));

    pepperoniIngredients = new ArrayList<>();
    pepperoniIngredients.add(new Ingredient("Tomato Sauce"));
    pepperoniIngredients.add(new Ingredient("Mozzarella"));
    pepperoniIngredients.add(new Ingredient("Pepperoni"));
    pepperoniIngredients.add(new Ingredient("Cheese"));
    pepperoniIngredients.add(new Ingredient("Oregano"));
  }
}
