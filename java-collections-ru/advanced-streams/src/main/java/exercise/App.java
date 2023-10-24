package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

// BEGIN
class App {

    static String getForwardedVariables(String content) {
        return Stream.of(content.split("[\n\r]"))
                .filter(Predicate.not(String::isEmpty))
                .map(String::trim)
                .filter(s -> s.startsWith("environment=\""))
                .map(s -> s.replaceAll("environment=\"", ""))
                .map(s -> s.replaceAll("\"", ""))
                .flatMap(s -> Stream.of(s.split(",")))
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
