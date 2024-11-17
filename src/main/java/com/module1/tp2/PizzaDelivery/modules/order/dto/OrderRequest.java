package com.module1.tp2.PizzaDelivery.modules.order.dto;

import com.module1.tp2.PizzaDelivery.modules.pizza.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderRequest {
  @NotNull(message = "Delivery address is required.")
  private final String deliveryAddress;
  @NotNull(message = "Client name is required.")
  private final String clientName;
  private List<Pizza> pizzas;
}
