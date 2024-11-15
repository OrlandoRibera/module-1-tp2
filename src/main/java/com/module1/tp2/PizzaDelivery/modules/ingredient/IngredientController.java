package com.module1.tp2.PizzaDelivery.modules.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
  @Autowired
  private IngredientService ingredientService;

  @GetMapping("/getAll")
  public List<Ingredient> getAllIngredients() {
    return ingredientService.getAllIngredients();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
    return ingredientService.getIngredientById(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
    return ingredientService.createIngredient(ingredient);
  }

  @PostMapping("/createInBulk")
  public List<Ingredient> createIngredients(@RequestBody List<Ingredient> ingredients) {
    return ingredientService.createIngredientsInBulk(ingredients);
  }
}
