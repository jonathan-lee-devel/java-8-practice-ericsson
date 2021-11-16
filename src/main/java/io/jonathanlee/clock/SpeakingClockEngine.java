package io.jonathanlee.clock;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpeakingClockEngine {

  private static final Map<String, String> hourWordMappings;

  private static final Map<String, String> firstMinuteWordMappings;

  private static final Map<String, String> secondMinuteWordMappings;

  private static final String MIDNIGHT_STRING = "12:00 am";
  private static final String NOON_STRING = "12:00 pm";

  static {
    hourWordMappings = new HashMap<>();
    hourWordMappings.put("0", "");
    hourWordMappings.put("1", "One");
    hourWordMappings.put("2", "Two");
    hourWordMappings.put("3", "Three");
    hourWordMappings.put("4", "Four");
    hourWordMappings.put("5", "Five");
    hourWordMappings.put("6", "Six");
    hourWordMappings.put("7", "Seven");
    hourWordMappings.put("8", "Eight");
    hourWordMappings.put("9", "Nine");
    hourWordMappings.put("10", "Ten");
    hourWordMappings.put("11", "Eleven");
    hourWordMappings.put("12", "Twelve");

    firstMinuteWordMappings = new HashMap<>();
    firstMinuteWordMappings.put("0", "O'");
    firstMinuteWordMappings.put("1", "Ten");
    firstMinuteWordMappings.put("2", "Twenty");
    firstMinuteWordMappings.put("3", "Thirty");
    firstMinuteWordMappings.put("4", "Forty");
    firstMinuteWordMappings.put("5", "Fifty");
    firstMinuteWordMappings.put("6", "Sixty");
    firstMinuteWordMappings.put("7", "Seventy");
    firstMinuteWordMappings.put("8", "Eighty");
    firstMinuteWordMappings.put("9", "Ninety");

    secondMinuteWordMappings = new HashMap<>(hourWordMappings);
  }

  public String speak(String time) {
    if (MIDNIGHT_STRING.equals(time)) {
      return "midnight";
    }
    if (NOON_STRING.equals(time)) {
      return "noon";
    }
    return String.format("%s %s %s",
        this.timeToHourWord(time),
        this.timeToMinuteWord(time),
        time.split(":")[1].split(" ")[1]);
  }

  String timeToHourWord(String time) {
    String hourValue = time.split(":")[0];
    return SpeakingClockEngine.hourWordMappings.get(hourValue);
  }

  String timeToMinuteWord(String time) {
    String minuteValue = time.split(":")[1].split(" ")[0];
    log.info("minuteValue = {}", minuteValue);
    StringBuilder stringBuilder = new StringBuilder();
    if ("00".equals(minuteValue)) {
      return "O'Clock";
    }
    stringBuilder.append(
        SpeakingClockEngine.firstMinuteWordMappings.get(String.valueOf(minuteValue.charAt(0))));

    stringBuilder.append(
        SpeakingClockEngine.secondMinuteWordMappings.get(String.valueOf(minuteValue.charAt(1)))
    );
    String finalString = stringBuilder.toString();

    switch (finalString) {
      case "TenOne":
        return "Eleven";
      case "TenTwo":
        return "Twelve";
      case "TenThree":
        return "Thirteen";
      case "TenFour":
        return "Fourteen";
      case "TenFive":
        return "Fifteen";
      case "TenSix":
        return "Sixteen";
      case "TenSeven":
        return "Seventeen";
      case "TenEight":
        return "Eighteen";
      case "TenNine":
        return "Nineteen";
      default:
        return finalString;
    }
  }

}
