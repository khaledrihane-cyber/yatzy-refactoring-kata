import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RollTest {

    Roll rollDummy = new Roll(2,3,2,4,2);
    Roll yatzyRollDummy = new Roll(5,5,5,5,5);

    @Test
    void testGetEveryDiceWithItsCount_should_return_Map() {
        Map<Integer,Integer> diceWithItsCountMap = new HashMap<>();
        diceWithItsCountMap.put(2,3);
        diceWithItsCountMap.put(3,1);
        diceWithItsCountMap.put(4, 1);
        assertEquals(diceWithItsCountMap, rollDummy.getEveryDiceWithItsCount());
    }

    @Test
    void testCountDiceByValue_should_return_3() {
        assertEquals(3, rollDummy.countDiceByValue(2) );
    }

    @Test
    void testIsYatzy_should_return_false() {
        assertFalse(rollDummy.isYatzy());
    }

    @Test
    void testIsYatzy_should_return_true() {
        assertTrue(yatzyRollDummy.isYatzy());
    }

    @Test
    void testSum_rollDummy_should_return_13() {
        assertEquals(13, rollDummy.sum());
    }

    @Test
    void testFindPairs_rollDummy_should_return_1() {
     assertEquals(Arrays.asList(2), rollDummy.findPairs());
    }

    @Test
    void testGetDiceWithCountGreaterThan_2_should_return_2() {
        assertEquals(2, rollDummy.getDiceWithCountGreaterThan(2));
    }
}