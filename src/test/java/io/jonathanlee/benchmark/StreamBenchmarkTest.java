package io.jonathanlee.benchmark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.jonathanlee.lamdas.ListLamdas;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

@NoArgsConstructor
class StreamBenchmarkTest {

  private static final String LIST_LAMDAS_STRING_VALUE = "listLamdas";

  @Mock
  private ListLamdas listLamdas;

  @BeforeEach
  public void before() {
    Mockito
        .when(listLamdas.toString())
        .thenReturn(LIST_LAMDAS_STRING_VALUE);
  }

  @Test
  void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  void shouldBeCorrectToString() {
    assertEquals(LIST_LAMDAS_STRING_VALUE, listLamdas.toString());
  }

}
