package com.module1.tp2.PizzaDelivery.modules.order;

import com.module1.tp2.PizzaDelivery.modules.order.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @PostMapping("/create")
  public ResponseEntity<Order> create(@RequestBody OrderRequest orderRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(orderRequest));
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<Order>> getAll() {
    return ResponseEntity.status(HttpStatus.OK).body(orderService.getAll());
  }
}
