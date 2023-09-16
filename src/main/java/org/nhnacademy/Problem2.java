package org.nhnacademy;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Problem2 {

    private static final Logger logger = LoggerFactory.getLogger(Problem2.class);

    public static void problem2() {

        StatCalc calc = new StatCalc();
        inputNumber(calc);
        printStat(calc);

    }

    public static void printStat(StatCalc calc) {

        logger.info("총 입력 횟수는 {}", calc.getCount());
        logger.info("입력의 총 합은 {}", calc.getSum());
        logger.info("입력의 평균은 {}", calc.getMean());
        logger.info("입력의 표준편차는 {}", calc.getStandardDeviation());
        logger.info("입력의 최대값은 {}", calc.getMaxValue());
        logger.info("입력의 최소값은 {}", calc.getMinValue());

    }

    public static void inputNumber(StatCalc calc) {

        Scanner sc = new Scanner(System.in);

        double num;
        while (true) {
            num = sc.nextDouble();
            if (num == 0) {
                return;
            }
            calc.enter(num);
        }
    }


}


// getMax ,  getMin 추가하기

class StatCalc {

    private int count;   // Number of numbers that have been entered.
    private double sum;  // The sum of all the items that have been entered.
    private double squareSum;  // The sum of the squares of all the items.
    private double minValue = 987654321;
    private double maxValue = -987654321;

    /**
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
        count++;
        sum += num;
        squareSum += num * num;
        setMaxValue(num);
        setMinValue(num);
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMinValue(double num) {
        if (minValue > num) {
            minValue = num;
        }
    }

    public void setMaxValue(double num) {
        if (maxValue < num) {
            maxValue = num;
        }
    }

    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount() {
        return count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum() {
        return sum;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean() {
        return sum / count;
    }

    /**
     * Return the standard deviation of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getStandardDeviation() {
        double mean = getMean();
        return Math.sqrt(squareSum / count - mean * mean);
    }

}