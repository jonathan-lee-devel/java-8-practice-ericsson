package io.jonathanlee.lamdas;

import io.jonathanlee.model.Order;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortingLamdas {

  public static void main(String[] args) {
    final List<String> currencies = Arrays.asList("USD", "EUR", "AUD");
    log.info("Currencies: {}", currencies);
    currencies.sort((Comparator.naturalOrder()));
    log.info("Currencies: {}", currencies);
    
    final var random = new Random();
    final List<Order> orders = Arrays.asList(
        new Order(UUID.randomUUID().toString(), BigDecimal.valueOf(random.nextDouble() * 100.0)),
        new Order(UUID.randomUUID().toString(), BigDecimal.valueOf(random.nextDouble() * 100.0)),
        new Order(UUID.randomUUID().toString(), BigDecimal.valueOf(random.nextDouble() * 100.0))
    );
    log.info("Orders: {}", orders);
    orders.sort(Comparator.comparing(Order::getAmount));
    log.info("Orders: {}", orders);
  }

}
