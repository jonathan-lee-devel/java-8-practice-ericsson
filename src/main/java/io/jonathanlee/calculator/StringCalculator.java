package io.jonathanlee.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

  public int add(String numbersString) {
    String[] numbersStringSplit = numbersString.split(",|\n");

    List<Integer> negatives = new ArrayList<>();
    int sum = 0;
    for (String numberString : numbersStringSplit) {
      int number = Integer.parseInt(numberString);
      if (number < 0) {
        negatives.add(number);
      } else {
        sum += number;
      }
    }

    if (!negatives.isEmpty()) {
      throw new IllegalArgumentException("Numbers cannot be negative, invalid input: " + negatives);
    }

    return sum;
  }

}
