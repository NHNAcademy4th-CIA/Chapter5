package org.nhnacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Problem1 {


    private static final Logger logger = LoggerFactory.getLogger(Problem1.class);

    public static void problem1() {

        logger.info("{}",printCount());
    }

    public static void printDiceStat(PairOfDice pairOfDice){
        logger.info("{}",pairOfDice);
    }

    public static int printCount() {

        PairOfDice pairOfDice;
        int count = 0;

        do {
            pairOfDice = new PairOfDice();
            printDiceStat(pairOfDice);
            count++;
        } while (pairOfDice.getDice1()+pairOfDice.getDice2()!=2);
        return count;
    }


}

class PairOfDice {

    private int dice1;
    private int dice2;

    public PairOfDice() {
        this.dice1 = (int)(Math.random()*6+1);
        this.dice2 = (int)(Math.random()*6+1);
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
