package io.jonathanlee.matchers;

import java.util.List;
import org.hamcrest.Matcher;

public class MyMatchers {

  private MyMatchers() {
  }

  public static StartAndEndCharacterMatcher endsAndStartsWith(String inputString) {
    return new StartAndEndCharacterMatcher(inputString);
  }

  public static IntegerArrayMatcher allAre(List<Integer> integers,
      Matcher<Integer> matcher) {
    return new IntegerArrayMatcher(integers, matcher);
  }

  public static GreaterThanMatcher greaterThan(Integer integer) {
    return new GreaterThanMatcher(integer);
  }

}
