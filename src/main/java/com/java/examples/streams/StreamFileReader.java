package com.java.examples.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StreamFileReader {
    public static void main(String[] args) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of("./src/main/resources/bookIndex.txt"))) {
            lines.forEach(System.out::println);
        }
    }
}
