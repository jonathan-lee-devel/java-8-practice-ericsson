package io.jonathanlee.lamdas;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLamdas {

  public static void main(String[] args) {
    final int numberOfCores = Runtime.getRuntime().availableProcessors();
    log.info("Number of cores: {}", numberOfCores);

    final ExecutorService executorService = Executors.newFixedThreadPool(numberOfCores);
    executorService.submit(() -> {
      log.info("Running...");
      final Random random = new Random();
      log.info("Random number: {}", random.nextInt());
    });
    executorService.shutdown();
  }

}
