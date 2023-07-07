import java.util.Comparator;
import java.util.List;

/***
 * Class contains methods that compute score in every Category
 */
public class Yatzy {

    /***
     * compute score in  chance category using the sum of the dices
     * @param roll
     * @return score based on chance logic
     */
    public static int chance(Roll roll) {
        return roll.sum();
    }

    /***
     * Verify is the roll is Yatzy
     * @param roll
     * @return fifty if yatzy and zero if not
     */
    public static int yatzy(Roll roll) {
        return roll.isYatzy() ? 50 : 0;
    }

    /***
     * count number of one dice in the roll Given
     * @param roll
     * @return number of ones
     */
    public static int ones(Roll roll) {
        return roll.countDiceByValue(1);
    }

    /***
     * count number of two dice and mutiply it by two
     * @param roll
     * @return number of twos * 2
     */
    public static int twos(Roll roll) {
        return roll.countDiceByValue(2) * 2;
    }

    /***
     * count number of  dice having three  and mutiply it by three
     * @param roll
     * @return number of three * 3
     */
    public static int threes(Roll roll) {
        return roll.countDiceByValue(3) * 3;
    }

    /***
     * count number of  dice having four  and mutiply it by four
     * @param roll
     * @return number of four * 4
     */
    public static int fours(Roll roll) {
        return roll.countDiceByValue(4) * 4;
    }

    /***
     * count number of  dice having five  and mutiply it by five
     * @param roll
     * @return number of five * 5
     */
    public static int fives(Roll roll) {
        return roll.countDiceByValue(5) * 5;
    }

    /***
     * count number of  dice having six  and mutiply it by six
     * @param roll
     * @return number of six * 6
     */
    public static int sixes(Roll roll) {
        return roll.countDiceByValue(6) * 6;
    }

    /***
     * count number of  pair dice
     * @param roll
     * @return number of pair dice
     */
    public static int pair(Roll roll) {
        return roll.findPairs()
                .stream()
                .max(Comparator.naturalOrder())
                .map(dice -> dice * 2)
                .orElse(0);
    }

    /***
     * count number of  two pairs of dices
     * @param roll
     * @return number of two pairs of dices
     */
    public static int twoPairs(Roll roll) {
        List<Integer> pairs = roll.findPairs();
        if (pairs.size() >= 2) {
            return pairs.stream()
                    .mapToInt(pair -> pair * 2)
                    .sum();
        }
        return 0;
    }

    /***
     * compute score if the roll contains 3 or greater
     * @param roll
     * @return compute score if the roll contains 3 or greater
     */
    public static int threeOfAKind(Roll roll) {
        return roll.getDiceWithCountGreaterThan(3) * 3;
    }

    /***
     * compute score in  fourOfAKind category
     * @param roll
     * @return score based on fourOfAKind logic
     */
    public static int fourOfAKind(Roll roll) {
        return roll.getDiceWithCountGreaterThan(4) * 4;
    }

    /***
     * compute score in  smallStraight category
     * @param roll
     * @return score based on smallStraight logic
     */
    public static int smallStraight(Roll roll) {
        return roll.isSmallStraight() ? 15 : 0;
    }

    /***
     * compute score in  largeStraight category
     * @param roll
     * @return score based on largeStraight logic
     */
    public static int largeStraight(Roll roll) {
        return roll.isLargeStraight() ? 20 : 0;
    }

    /***
     * compute score in  fullHouse category
     * @param roll
     * @return score in fullHouse
     */
    public static int fullHouse(Roll roll) {
        return (roll.getDiceWithCountGreaterThan(3) != 0 && !roll.findPairs().isEmpty() && !roll.isYatzy()) ? roll.sum() : 0;
    }

    /***
     *  Calculate score based on given Category and Roll
     * @param category
     * @param roll
     * @return score int
     */
    public static int getScore(Category category, Roll roll) {
        int score = 0;
        switch (category) {
            case YATZY_SCORE:
                score = yatzy(roll);
                break;
            case CHANCE:
                score = chance(roll);
                break;
            case ONES:
                score = ones(roll);
                break;
            case TWOS:
                score = twos(roll);
                break;
            case THREES:
                score = threes(roll);
                break;
            case FOURS:
                score = fours(roll);
                break;
            case FIVES:
                score = fives(roll);
                break;
            case SIXES:
                score = sixes(roll);
                break;
            case TWO_PAIRS:
                score = twoPairs(roll);
                break;
            case PAIR:
                score = pair(roll);
                break;
            case SMALL_STRAIGHT:
                score = smallStraight(roll);
                break;
            case LARGE_STRAIGHT:
                score = largeStraight(roll);
                break;
            case THREE_OF_A_KIND:
                score = threeOfAKind(roll);
                break;
            case FOR_OF_A_KIND:
                score = fourOfAKind(roll);
                break;
            case FULL_HOUSE:
                score = fullHouse(roll);
                break;
            default:
                score = 0;

        }
        return score;
    }


}




