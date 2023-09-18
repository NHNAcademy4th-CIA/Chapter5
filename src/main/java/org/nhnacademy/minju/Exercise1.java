package org.nhnacademy.minju;

import org.nhnacademy.minju.classes.PairOfDice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .using PairOfDice, counts how many times a pair of dice is rolled
 * before the total of the two dice is equal to two.
 */
public class Exercise1 {
    private static final Logger logger = LoggerFactory.getLogger(Exercise1.class);

    /**
     * .until dice sum equals 2, roll dice
     */
    public static void exercise1() {
        PairOfDice pairOfDice = new PairOfDice();
        while (pairOfDice.getDiceSum() != 2) {
            pairOfDice.roll();
        }
        logger.info("{}", pairOfDice);
    }
}