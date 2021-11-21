package io.jonathanlee.hamcrest;

import org.hamcrest.Matcher;

public class MyMatchers {

    public static AllElementsOfListMatcher allAre(Matcher<Integer> typeSafeMatcher) {
        return new AllElementsOfListMatcher(typeSafeMatcher);
    }

}
