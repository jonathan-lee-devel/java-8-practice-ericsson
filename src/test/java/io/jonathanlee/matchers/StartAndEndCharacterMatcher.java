package io.jonathanlee.matchers;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

@RequiredArgsConstructor
public class StartAndEndCharacterMatcher extends TypeSafeMatcher<String> {

  private final String value;

  @Override
  protected boolean matchesSafely(String s) {
    return s.startsWith(String.valueOf(s.charAt(0))) && s.endsWith(
        String.valueOf(s.charAt(s.length() - 1)));
  }

  @Override
  public void describeTo(Description description) {
    description.appendText(
        String.format("%s should both start and end with %s", this.value, this.value.charAt(0)));
  }

}
