package io.jonathanlee.calculator;

import java.util.Arrays;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Slf4j
@RequiredArgsConstructor
class StringCalculatorUnitTests {

  private final String input;
  private final Integer result;

  private StringCalculator stringCalculator;

  private static Collection normalData() {
    Object[][] arrayData = {{"1,2", 3}, {"1,2,3", 6}, {"1\n2", 3}, {"1\n2\n3", 6}, {"1\n2,3", 6}};
    return Arrays.asList(arrayData);
  }

  private static Collection negativeData() {
    Object[][] arrayData = {{"-1,2", 3}, {"1,-2,3", 6}, {"1\n-2", 3}, {"1\n2\n-3", 6},
        {"1\n-2,3", 6}};
    return Arrays.asList(arrayData);
  }

  @BeforeEach
  public void init() {
    this.stringCalculator = new StringCalculator();
  }

  @ParameterizedTest
  @MethodSource("normalData")
  void whenAddNumbers_thenCorrectSumReturned() throws Exception {
    Assertions.assertEquals(result.longValue(), this.stringCalculator.add(this.input));
  }

  @ParameterizedTest
  @MethodSource("ngativeData")
  void whenAddNegativeNumbers_thenIllegalArgumentExceptionThrown() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      this.stringCalculator.add(this.input);
    });
  }

}
