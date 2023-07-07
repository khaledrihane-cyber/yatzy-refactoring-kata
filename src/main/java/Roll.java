import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/***
 * Class contains method in relation with the Roll isYatzy, sum of elements,...
 */
public class Roll {


    private final List<Integer> diceList;

    public Roll(int d1, int d2, int d3, int d4, int d5) {
        this.diceList = Arrays.asList(d1, d2, d3, d4, d5);
    }

    /***
     * create a Map that contains dice as key and it count in the roll as value
     * @return Map of dice and count of dice in the list
     */
    public Map<Integer, Integer> getEveryDiceWithItsCount() {
        return diceList.stream().collect(Collectors.groupingBy(d -> d, Collectors.summingInt(d -> 1)));
    }

    /***
     * get the count of given dice from Map<dice, count></dice,>
     * @param dice
     * @return  count of given dice
     */
    public int countDiceByValue(int dice) {
        return getEveryDiceWithItsCount().getOrDefault(dice, 0);
    }

    /***
     * verify if map contains a count of 5 elements in it
     * @return boolean
     */
    public boolean isYatzy() {
        return getEveryDiceWithItsCount()
                .values()
                .stream()
                .anyMatch(count -> count == 5);
    }

    /***
     * make the sum of all roll element
     * @return the sum of elements
     */
    public int sum() {
        return diceList.stream().mapToInt(Integer::intValue).sum();
    }

    /***
     * get Dice with counter greater than
     * @param n
     * @return number
     */
    public int getDiceWithCountGreaterThan(int n) {
        return getNumberOfDiceGreaterThan(n)
                .findFirst()
                .orElse(0);
    }

    /***
     *
     * @param n
     * @return
     */
    private Stream<Integer> getNumberOfDiceGreaterThan(int n) {
        return getEveryDiceWithItsCount().entrySet().stream()
                .filter(entry -> entry.getValue() >= n)
                .map(Entry::getKey);
    }

    /***
     * find all pairs of dice
     * @return
     */
    public List<Integer> findPairs() {
        return getNumberOfDiceGreaterThan(2).collect(toList());
    }

    /***
     * verify if the roll is small straight
     * @return boolean
     */
    public boolean isSmallStraight() {
        return diceList.stream()
                       .sorted()
                       .collect(toList())
                       .equals(Arrays.asList(1, 2, 3, 4, 5));
    }

    /***
     * Verify if the roll is large straight
     * @return boolean
     */
    public boolean isLargeStraight() {
        return diceList.stream()
                .sorted()
                .collect(toList())
                .equals(Arrays.asList(2, 3, 4, 5, 6));
    }

}