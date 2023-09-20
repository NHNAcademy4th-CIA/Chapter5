package org.nhnacademy.minju;

import java.util.Scanner;
import org.nhnacademy.minju.classes.StatCalc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .Modify the current source code, StatCalc.java,
 * to add instance methods getMax() and getMin(). The getMax() method
 */
public class Exercise2 {
    private static final Logger logger = LoggerFactory.getLogger(Exercise2.class);

    /**
     * .with input, run calc
     * if input equals 0 then print
     */
    public static void exercise2() {
        StatCalc calc;
        calc = new StatCalc();
        Scanner scanner = new Scanner(System.in);
        double inputNum;
        while ((inputNum = scanner.nextDouble()) != 0) {
            calc.enter(inputNum);
        }
        print(calc);
    }

    /**
     * .print statCalc variable
     *
     * @param statCalc statCalc
     */
    public static void print(StatCalc statCalc) {
        logger.info("Total Count : {}", statCalc.getCount());
        logger.info("Sum : {}", statCalc.getSum());
        if (statCalc.getCount() < 1) {
            // 0이 입력되면 출력하지 않음
            return;
        }
        logger.info("Mean : {}", statCalc.getMean());
        logger.info("Standard Deviation : {}", statCalc.getStandardDeviation());
        logger.info("Maximum : {}", statCalc.getMax());
        logger.info("Minimum : {}", statCalc.getMin());
    }
}