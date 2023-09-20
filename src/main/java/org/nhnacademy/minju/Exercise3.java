package org.nhnacademy.minju;

import org.nhnacademy.minju.classes.PairOfDice;
import org.nhnacademy.minju.classes.StatCalc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .counting how many times a pair of dice is rolled before a given total comes up.
 * It repeats this experiment 10000 times and then reports the average number of rolls.
 * It does this whole process for each possible total (2, 3, ..., 12).
 */
public class Exercise3 {
    private static final Logger logger = LoggerFactory.getLogger(Exercise3.class);

    /**
     * .loop for possible total, roll dice
     */
    public static void exercise3() {

        for (int i = 2; i <= 12; i++) {
            StatCalc statCalc = new StatCalc();

            for (int j = 0; j < 10_000; j++) {
                statCalc.enter(rollDice(i));
            }
            logger.info("total of dice : {}", i);
            logger.info("mean : {}", statCalc.getMean());
            logger.info("standard deviation : {}", statCalc.getStandardDeviation());
            logger.info("max : {}", statCalc.getMax());
        }

    }

    private static double rollDice(int number) {
        PairOfDice dice = new PairOfDice();
        do {
            dice.roll();
        } while (number != dice.getDiceSum());
        return dice.getCount();
    }
}
