package io.jonathanlee.benchmark;

import java.util.UUID;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamBenchmark {

  public static void main(String[] args) throws InterruptedException {
    final Stream<String> generatedParallelStream = generateStream(true);
    performBenchmark(generatedParallelStream);
    generatedParallelStream.close();

    Thread.sleep(2000L);

    final Stream<String> generatedSequentialStream = generateStream(false);
    performBenchmark(generatedSequentialStream);
    generatedSequentialStream.close();
  }

  private static Stream<String> generateStream(boolean isParallel) {
    final Stream<String> generatedStream = Stream
        .generate(() -> UUID.randomUUID().toString())
        .limit(100_000_000L);

    return isParallel ? generatedStream.parallel() : generatedStream.sequential();
  }

  private static void performBenchmark(Stream<String> stream) {
    log.info("Benchmarking...");
    log.info("Is parallel: {}", stream.isParallel());

    final long start = System.currentTimeMillis();
    final boolean containsSmall = stream
        .map(String::length)
        .anyMatch(length -> length < 5);
    final long elapsed = System.currentTimeMillis() - start;

    log.info("Contains small: {}", containsSmall);
    log.info("Time elapsed: {} ms!", elapsed);
  }

}
