package com.module1.tp2.PizzaDelivery.modules.pizza;

import com.module1.tp2.PizzaDelivery.modules.ingredient.Ingredient;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pizza {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private double price;

  @ManyToMany
  private List<Ingredient> ingredients;
}
