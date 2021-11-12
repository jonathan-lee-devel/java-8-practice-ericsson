package io.jonathanlee;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) throws InterruptedException {
    Stream<String> generatedParallelStream = generateStream(true);
    performBenchmark(generatedParallelStream);
    generatedParallelStream.close();

    Thread.sleep(2000L);

    Stream<String> generatedSequentialStream = generateStream(false);
    performBenchmark(generatedSequentialStream);
    generatedSequentialStream.close();
  }

  private static Stream<String> generateStream(boolean isParallel) {
    Stream<String> generatedStream = Stream
        .generate(() -> UUID.randomUUID().toString())
        .limit(100_000_000L);

    return isParallel ? generatedStream.parallel() : generatedStream.sequential();
  }

  private static void performBenchmark(Stream<String> stream) {
    System.out.println("-----------------------------------");
    System.out.println("Benchmarking...");
    System.out.println("Is parallel: " + stream.isParallel());

    long start = System.currentTimeMillis();
    boolean containsSmall = stream
        .map(String::length)
        .anyMatch(length -> length < 5);
    long elapsed = System.currentTimeMillis() - start;

    System.out.println("Contains small: " + containsSmall);
    System.out.println("Time elapsed: " + elapsed + "ms!");
    System.out.println("-----------------------------------");
  }

  private static Stream<String> streamOf(List<String> list) {
    return list == null || list.isEmpty() ? Stream.empty() : list.stream();
  }

  private static Stream<String> parallelStreamOf(List<String> list) {
    return list == null || list.isEmpty() ? Stream.empty() : list.parallelStream();
  }

}
