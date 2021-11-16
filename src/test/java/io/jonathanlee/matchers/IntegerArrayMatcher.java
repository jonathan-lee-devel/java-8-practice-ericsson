package io.jonathanlee.matchers;

import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

@RequiredArgsConstructor
public class IntegerArrayMatcher extends TypeSafeMatcher<Matcher<Integer>> {

  private final Collection<Integer> integers;
  private final Matcher<Integer> typeSafeMatcher;

  @Override
  protected boolean matchesSafely(Matcher<Integer> integerMatcher) {
    return false;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("Each and every integer must match the given condition");
  }

}
