package io.jonathanlee.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

  private String id;
  private BigDecimal amount;

}
