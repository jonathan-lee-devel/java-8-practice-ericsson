package io.jonathanlee.fizzbuzz;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FizzBuzz {

  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {
      log.info("{}", FizzBuzz.fizzBuzz(i));
    }
  }

  public static String fizzBuzz(int i) {
    if (i % 3 == 0 && i % 5 == 0) {
      return "FizzBuzz";
    } else if (i % 3 == 0) {
      return "Fizz";
    } else if (i % 5 == 0) {
      return "Buzz";
    } else {
      return String.valueOf(i);
    }
  }

}
