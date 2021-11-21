package io.jonathanlee.hamcrest;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

@RequiredArgsConstructor
public class AllElementsOfListMatcher extends TypeSafeMatcher<List<Integer>> {

    private final Matcher<Integer> typeSafeMatcher;

    @Override
    protected boolean matchesSafely(List<Integer> integers) {
        for (Integer integer : integers) {
            if (!typeSafeMatcher.matches(integer)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {

    }

}
