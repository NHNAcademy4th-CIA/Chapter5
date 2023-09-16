package org.nhnacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Problem3 {

    private static final Logger logger = LoggerFactory.getLogger(Problem3.class);

    public static void problem3() {

        StatCalc[] calc = new StatCalc[13];

        initStatCalc(calc);

        int number;
        int count;

        for (int i = 0; i < 10000; i++) {

            number = (int) (Math.random() * 11 + 2);

            count = rollDice(number);

            calc[number].enter(count);


        }


        for (int i = 2; i <= 12; i++) {
            printStat(calc[i],i);
        }

    }

    public static void initStatCalc(StatCalc[] calc) {
        for (int i = 0; i < calc.length; i++) {
            calc[i] = new StatCalc();
        }
    }

    public static void printStat(StatCalc calc, int index) {

        logger.info("숫자 {} 평균 롤 횟수 {}", index, calc.getMean());
        logger.info("숫자 {} 표준 롤 편차는 {}", index, calc.getStandardDeviation());
        logger.info("숫자 {} 최대 롤수는 {}\n", index, calc.getMaxValue());

    }

    public static int rollDice(int num) {


        int count = 0;
        PairOfDice pairOfDice;
        do {
            count++;
            pairOfDice = new PairOfDice();
        } while (pairOfDice.getDice1() + pairOfDice.getDice2() != num);

        return count;

    }

}
