package io.jonathanlee.lamdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListLamdas {

  public static void main(String[] args) {
    final List<Integer> integers = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      integers.add(new Random().nextInt());
    }

    integers.forEach(integer -> log.info("Value: {}", integer));
  }

}
