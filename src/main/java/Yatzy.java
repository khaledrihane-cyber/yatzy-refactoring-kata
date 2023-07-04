import java.util.Comparator;
import java.util.List;

public class Yatzy {

    public static int chance(Roll roll) {
        return roll.sum();
    }

    public static int yatzy(Roll roll) {
        return roll.isYatzy() ? 50 : 0;
    }

    public static int ones(Roll roll) {
        return roll.countDiceByValue(1);
    }

    public static int twos(Roll roll) {
        return roll.countDiceByValue(2) * 2;
    }

    public static int threes(Roll roll) {
        return roll.countDiceByValue(3) * 3;
    }

    public static int fours(Roll roll) {
        return roll.countDiceByValue(4) * 4;
    }

    public static int fives(Roll roll) {
        return roll.countDiceByValue(5) * 5;
    }

    public static int sixes(Roll roll) {
        return roll.countDiceByValue(6) * 6;
    }

    public static int pair(Roll roll) {
        return roll.findPairs()
                .stream()
                .max(Comparator.naturalOrder())
                .map(dice -> dice * 2)
                .orElse(0);
    }


    public static int twoPairs(Roll roll) {
        List<Integer> pairs = roll.findPairs();
        if (pairs.size() >= 2) {
            return pairs.stream()
                    .mapToInt(pair -> pair * 2)
                    .sum();
        }
        return 0;
    }

    public static int threeOfAKind(Roll roll) {
        return roll.getDiceWithCountGreaterThan(3) * 3;
    }

    public static int fourOfAKind(Roll roll) {
        return roll.getDiceWithCountGreaterThan(4) * 4;
    }



    public static int smallStraight(Roll roll) {
        return roll.isSmallStraight() ? 15: 0;
    }

    public static int largeStraight(Roll roll) {
        return roll.isLargeStraight() ? 20: 0;
    }

    public static int fullHouse(Roll roll) {
        return (roll.getDiceWithCountGreaterThan(3) != 0 && !roll.findPairs().isEmpty() && !roll.isYatzy()) ? roll.sum(): 0 ;
    }

}