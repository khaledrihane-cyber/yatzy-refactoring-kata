import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Roll {


    private final List<Integer> diceList;

    public Roll(int d1, int d2, int d3, int d4, int d5) {
        this.diceList = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public Map<Integer, Integer> getEveryDiceWithItsCount() {
        return diceList.stream().collect(Collectors.groupingBy(d -> d, Collectors.summingInt(d -> 1)));
    }

    public int countDiceByValue(int dice) {
        return getEveryDiceWithItsCount().getOrDefault(dice, 0);
    }


    public boolean isYatzy() {
        return getEveryDiceWithItsCount()
                .values()
                .stream()
                .anyMatch(count -> count == 5);
    }


    public int sum() {
        return diceList.stream().mapToInt(Integer::intValue).sum();
    }

    public int getDiceWithCountGreaterThan(int n) {
        return getNumberOfDiceGreaterThan(n)
                .findFirst()
                .orElse(0);
    }

    private Stream<Integer> getNumberOfDiceGreaterThan(int n) {
        return getEveryDiceWithItsCount().entrySet().stream()
                .filter(entry -> entry.getValue() >= n)
                .map(Entry::getKey);
    }

    public List<Integer> findPairs() {
        return getNumberOfDiceGreaterThan(2).collect(toList());
    }


    public boolean isSmallStraight() {
        return diceList.stream()
                       .sorted()
                       .collect(toList())
                       .equals(Arrays.asList(1, 2, 3, 4, 5));
    }

    public boolean isLargeStraight() {
        return diceList.stream()
                .sorted()
                .collect(toList())
                .equals(Arrays.asList(2, 3, 4, 5, 6));
    }

}