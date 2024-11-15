package com.module1.tp2.PizzaDelivery.modules.ingredient;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
  private final IngredientRepository ingredientRepository;

  public IngredientService(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  public List<Ingredient> getAllIngredients() {
    return (List<Ingredient>) ingredientRepository.findAll();
  }

  public Optional<Ingredient> getIngredientById(Long id) {
    return ingredientRepository.findById(id);
  }

  public Ingredient createIngredient(Ingredient ingredient) {
    return ingredientRepository.save(ingredient);
  }

  public List<Ingredient> createIngredientsInBulk(List<Ingredient> ingredients) {
    return (List<Ingredient>) ingredientRepository.saveAll(ingredients);
  }
}
