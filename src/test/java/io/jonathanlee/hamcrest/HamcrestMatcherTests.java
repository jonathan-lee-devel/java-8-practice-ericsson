package io.jonathanlee.hamcrest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HamcrestMatcherTests {

    @Test
    public void test_whenOneGreaterThanZero_thenReturnTrue() {
        org.hamcrest.MatcherAssert.assertThat(1, org.hamcrest.Matchers.greaterThan(0));
    }

    @Test
    public void test_whenAllElementsGreaterThanZero_thenReturnTrue() {
        org.hamcrest.MatcherAssert.assertThat(Arrays.asList(1, 2, 3), MyMatchers.allAre(org.hamcrest.Matchers.greaterThan(0)));
    }

    @Test
    public void test_whenNotAllElementsGreaterThanZero_thenReturnFalse() {
        org.hamcrest.MatcherAssert.assertThat(Arrays.asList(0, 1, 2, 3), org.hamcrest.Matchers.not(MyMatchers.allAre(org.hamcrest.Matchers.greaterThan(0))));
    }

}
