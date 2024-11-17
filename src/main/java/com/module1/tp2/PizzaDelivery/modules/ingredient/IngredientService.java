package com.module1.tp2.PizzaDelivery.modules.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
  @Autowired
  private IngredientRepository ingredientRepository;

  public List<Ingredient> getAllIngredients() {
    return (List<Ingredient>) ingredientRepository.findAll();
  }

  public List<Ingredient> getIngredientsById(List<Long> ids) {
    return (List<Ingredient>) ingredientRepository.findAllById(ids);
  }

  public Optional<Ingredient> getIngredientById(Long id) {
    return ingredientRepository.findById(id);
  }

  public Ingredient getIngredientByName(String name) {
    return ingredientRepository.findByName(name);
  }

  public Ingredient createIngredient(Ingredient ingredient) {
    return ingredientRepository.save(ingredient);
  }

  public List<Ingredient> createIngredientsInBulk(List<Ingredient> ingredients) {
    return (List<Ingredient>) ingredientRepository.saveAll(ingredients);
  }

  public double getTotalPrice(List<Ingredient> ingredients) {
    double total = 0;
    for (Ingredient ingredient : ingredients) {
      Optional<Ingredient> ingredientFound = getIngredientById(ingredient.getId());
      if (ingredientFound.isPresent()) {
        total += ingredientFound.get().getPrice();
      }
    }
    return total;
  }
}
