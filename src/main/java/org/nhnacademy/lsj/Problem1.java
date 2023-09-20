package org.nhnacademy.lsj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 두 주사위의 합이 2가 될 때까지 줏위 한 쌍을 굴린 회수를 계산하는 프로그램 .
 */
public class Problem1 {


    private static final Logger logger = LoggerFactory.getLogger(Problem1.class);

    public static void problem1() {

        logger.info("{}", untilGetTwo());
    }

    public static void printDiceStat(PairOfDice pairOfDice) {
        logger.info("{}", pairOfDice);
    }

    /**
     * 주사위의 합이 2가 나올때 까지 돌린 횟수를 출력 .
     *
     * @return 돌린 횟수.
     */
    public static int untilGetTwo() {

        PairOfDice pairOfDice;
        int count = 0;

        do {
            pairOfDice = new PairOfDice();
            printDiceStat(pairOfDice);
            count++;
        } while (pairOfDice.getDice1() + pairOfDice.getDice2() != 2);
        return count;
    }


}

/**
 * 주사위 2개를 가진 클래스.
 */
class PairOfDice {

    private int dice1;
    private int dice2;

    public PairOfDice() {
        this.dice1 = (int) (Math.random() * 6 + 1);
        this.dice2 = (int) (Math.random() * 6 + 1);
    }

    public int getDice1() {
        return dice1;
    }


    public int getDice2() {
        return dice2;
    }

    @Override
    public String toString() {
        return "Dice1 : " + this.dice1 + "  Dice2 : " + this.dice2 + " = total " + (this.dice1 + this.dice2);
    }

}
