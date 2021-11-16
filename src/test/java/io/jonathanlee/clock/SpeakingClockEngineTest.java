package io.jonathanlee.clock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpeakingClockEngineTest {

  private SpeakingClockEngine speakingClockEngine;

  @BeforeEach
  public void init() {
    this.speakingClockEngine = new SpeakingClockEngine();
  }

  @Test
  void test_whenInputTwelveAm_thenReturnMidnight() {
    String input = "12:00 am";
    Assertions.assertEquals("midnight", this.speakingClockEngine.speak(input));
  }

  @Test
  void test_whenInputTwelvePm_thenReturnNoon() {
    String input = "12:00 pm";
    Assertions.assertEquals("noon", this.speakingClockEngine.speak(input));
  }

  @Test
  void test_whenInputTime_thenReturnCorrectHour() {
    String[] inputs = {
        "1:00 am",
        "2:00 am",
        "3:00 am",
        "4:00 am",
        "5:00 am",
        "6:00 am",
        "7:00 am",
        "8:00 am",
        "9:00 am",
        "10:00 am",
        "11:00 am"
    };
    String[] outputs = {
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven"
    };
    for (int i = 0; i < inputs.length; i++) {
      Assertions.assertEquals(this.speakingClockEngine.timeToHourWord(inputs[i]), outputs[i]);
    }
  }

  @Test
  void test_whenInputTime_thenReturnCorrectMinute() {
    String[] inputs = {
        "1:00",
        "1:01",
        "1:02",
        "1:03",
        "1:04",
        "1:05",
        "1:06",
        "1:07",
        "1:08",
        "1:09",
        "1:10",
        "1:11",
        "1:12",
        "1:13",
        "1:14",
        "1:15",
        "1:16",
        "1:17",
        "1:18",
        "1:19",
        "1:20"
    };
    String[] outputs = {
        "O'Clock",
        "O'One",
        "O'Two",
        "O'Three",
        "O'Four",
        "O'Five",
        "O'Six",
        "O'Seven",
        "O'Eight",
        "O'Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen",
        "Twenty",
    };
    for (int i = 0; i < inputs.length; i++) {
      Assertions.assertEquals(outputs[i], this.speakingClockEngine.timeToMinuteWord(inputs[i]));
    }
  }

  @Test
  void test_whenInputTime_thenClockSpeaksCorrectly() {
    String input = "7:32 pm";
    Assertions.assertEquals("Seven ThirtyTwo pm", this.speakingClockEngine.speak(input));
  }

}
