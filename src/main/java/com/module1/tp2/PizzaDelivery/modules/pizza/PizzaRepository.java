package com.module1.tp2.PizzaDelivery.modules.pizza;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
