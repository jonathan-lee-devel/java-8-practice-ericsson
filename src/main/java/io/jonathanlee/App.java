package io.jonathanlee;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws InterruptedException {

        Stream<String> generatedSequentialStream = Stream.generate(() -> UUID.randomUUID().toString()).limit(Long.MAX_VALUE).sequential();
        if (!generatedSequentialStream.isParallel()) {
            long start = System.currentTimeMillis();
            boolean containsLarge = generatedSequentialStream
                    .map(String::length)
                    .anyMatch(length -> length > 5);
            long elapsed = System.currentTimeMillis() - start;

            System.out.println("Sequential contains large: " + containsLarge);
            System.out.println("Time elapsed: " + elapsed + "ms!");
        }
        generatedSequentialStream.close();

        Thread.sleep(2000L);

        Stream<String> generatedParallelStream = Stream.generate(() -> UUID.randomUUID().toString()).limit(Long.MAX_VALUE).parallel();
        if (generatedParallelStream.isParallel()) {
            long start = System.currentTimeMillis();
            boolean containsLarge = generatedParallelStream
                    .map(String::length)
                    .anyMatch(length -> length > 5);
            long elapsed = System.currentTimeMillis() - start;

            System.out.println("Parallel contains large: " + containsLarge);
            System.out.println("Time elapsed: " + elapsed + "ms!");
        }
        generatedSequentialStream.close();
    }

    public static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    public static Stream<String> parallelStreamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.parallelStream();
    }

}
