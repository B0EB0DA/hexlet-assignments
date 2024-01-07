package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> homes, int num) {
        return homes.stream()
                .sorted((h1, h2) -> h1.compareTo(h2))
                .limit(num)
                .map(h -> h.toString())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        System.out.println(buildApartmentsList(apartments, 3));
    }
}
// END
