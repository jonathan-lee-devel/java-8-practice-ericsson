package io.jonathanlee.matchers;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

@RequiredArgsConstructor
public class GreaterThanMatcher extends TypeSafeMatcher<Integer> {

  private final Integer integer;

  @Override
  protected boolean matchesSafely(Integer integer) {
    return this.integer < integer;
  }

  @Override
  public void describeTo(Description description) {

  }

}
