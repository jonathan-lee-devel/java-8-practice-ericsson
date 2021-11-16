package io.jonathanlee.fizzbuzz;

import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@NoArgsConstructor
public class FizzBuzzTest {

  private static final String FIZZ = "Fizz";
  private static final String BUZZ = "Buzz";
  private static final String FIZZ_BUZZ = "FizzBuzz";

  @Test
  public void whenMultipleOfThree_thenPrintFizz() {
    Assertions.assertEquals(FIZZ, FizzBuzz.fizzBuzz(3));
    Assertions.assertEquals(FIZZ, FizzBuzz.fizzBuzz(6));
    Assertions.assertEquals(FIZZ, FizzBuzz.fizzBuzz(9));
    Assertions.assertEquals(FIZZ, FizzBuzz.fizzBuzz(12));
  }

  @Test
  public void whenMultipleOfFive_thenPrintBuzz() {
    Assertions.assertEquals(BUZZ, FizzBuzz.fizzBuzz(5));
    Assertions.assertEquals(BUZZ, FizzBuzz.fizzBuzz(10));
    Assertions.assertEquals(BUZZ, FizzBuzz.fizzBuzz(20));
    Assertions.assertEquals(BUZZ, FizzBuzz.fizzBuzz(25));
  }

  @Test
  public void whenMultipleOfFiveAndThree_thenPrintFizzBuzz() {
    Assertions.assertEquals(FIZZ_BUZZ, FizzBuzz.fizzBuzz(15));
    Assertions.assertEquals(FIZZ_BUZZ, FizzBuzz.fizzBuzz(30));
    Assertions.assertEquals(FIZZ_BUZZ, FizzBuzz.fizzBuzz(45));
    Assertions.assertEquals(FIZZ_BUZZ, FizzBuzz.fizzBuzz(60));
  }

  @Test
  public void whenNotMultiple_thenPrintNumber() {
    Assertions.assertEquals(String.valueOf(1), FizzBuzz.fizzBuzz(1));
    Assertions.assertEquals(String.valueOf(2), FizzBuzz.fizzBuzz(2));
    Assertions.assertEquals(String.valueOf(4), FizzBuzz.fizzBuzz(4));
    Assertions.assertEquals(String.valueOf(7), FizzBuzz.fizzBuzz(7));
  }

}
