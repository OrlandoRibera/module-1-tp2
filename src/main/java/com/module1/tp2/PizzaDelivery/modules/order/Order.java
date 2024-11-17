package com.module1.tp2.PizzaDelivery.modules.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.module1.tp2.PizzaDelivery.modules.pizza.Pizza;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "pizza_order")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private LocalDateTime orderDate;
  private Double deliveryPrice;
  private String deliveryAddress;
  private String clientName;

  @ManyToMany
  private List<Pizza> pizzas;
}
