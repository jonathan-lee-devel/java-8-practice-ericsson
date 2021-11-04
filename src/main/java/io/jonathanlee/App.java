package io.jonathanlee;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws InterruptedException {

        Stream<String> generatedSequentialStream = generateStream(false);
        performBenchmark(generatedSequentialStream);
        generatedSequentialStream.close();

        Thread.sleep(2000L);

        Stream<String> generatedParallelStream = generateStream(true);
        performBenchmark(generatedParallelStream);
        generatedSequentialStream.close();
    }

    private static Stream<String> generateStream(boolean isParallel) {
        Stream<String> generatedStream = Stream
                .generate(() -> UUID.randomUUID().toString())
                .limit(Long.MAX_VALUE);

        return isParallel ? generatedStream.parallel() : generatedStream.sequential();
    }

    private static void performBenchmark(Stream<String> stream) {
        long start = System.currentTimeMillis();
        boolean containsLarge = stream
                .map(String::length)
                .anyMatch(length -> length > 5);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("-----------------------------------");
        System.out.println("Is parallel: " + stream.isParallel());
        System.out.println("Contains large: " + containsLarge);
        System.out.println("Time elapsed: " + elapsed + "ms!");
    }

    private static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    private static Stream<String> parallelStreamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.parallelStream();
    }

}
