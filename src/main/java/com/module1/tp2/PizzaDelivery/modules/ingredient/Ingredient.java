package com.module1.tp2.PizzaDelivery.modules.ingredient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.module1.tp2.PizzaDelivery.modules.pizza.Pizza;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(unique = true)
  private String name;
  private double price;

  public Ingredient(Long id) {
    this.id = id;
  }

  public Ingredient(String name) {
    this.name = name;
  }
}
