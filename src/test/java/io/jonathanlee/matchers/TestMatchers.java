package io.jonathanlee.matchers;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class TestMatchers {

  @Test
  void test_whenStartsAndEnds_thenReturnsTrue() {
    String input = "MyStringM";
    assertThat(input, MyMatchers.endsAndStartsWith(input));
  }

  @Test
  void test_whenGreaterThanNumber_thenReturnsTrue() {
    Integer input = 1;
    assertThat(input, MyMatchers.greaterThan(0));
  }

  @Test
  void test_whenUniformIntegers_thenReturnsTrue() {
    List<Integer> input = Arrays.asList(1, 1, 1, 1, 1);
    assertThat(input, everyItem(greaterThan(0)));
//    assertThat(input, MyMatchers.allAre(input, greaterThan(0)));
  }

}
