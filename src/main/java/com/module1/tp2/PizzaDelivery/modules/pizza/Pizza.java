package com.module1.tp2.PizzaDelivery.modules.pizza;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.module1.tp2.PizzaDelivery.modules.ingredient.Ingredient;
import com.module1.tp2.PizzaDelivery.modules.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pizza {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String type;
  private double price;

  @ManyToMany
  private List<Ingredient> ingredients;
}
