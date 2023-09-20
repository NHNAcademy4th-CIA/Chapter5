package org.nhnacademy.lsj;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 사용자로 부터 숫자를 받음 , 후에 calc에서 사용할 수 있는 6개의 통계를 인쇄 .
 */
public class Problem2 {

    private static final Logger logger = LoggerFactory.getLogger(Problem2.class);

    /**
     * 문제가 실질적으뢴행됨.
     */
    public static void problem2() {


        StatCalc calc = new StatCalc();
        inputNumber(calc);
        printStat(calc);


    }

    /**
     * calc가 가지는 6개의 통계를 출력한다.
     *
     * @param calc 집합의 통계를내는 클래스.
     */
    public static void printStat(StatCalc calc) {

        logger.info("총 입력 횟수는 {}", calc.getCount());
        logger.info("입력의 총 합은 {}", calc.getSum());
        logger.info("입력의 평균은 {}", calc.getMean());
        logger.info("입력의 표준편차는 {}", calc.getStandardDeviation());
        logger.info("입력의 최대값은 {}", calc.getMaxValue());
        logger.info("입력의 최소값은 {}", calc.getMinValue());

    }

    /**
     * 0이 아닌 수가 나올 떄 까지 숫자를 입력받음 .
     *
     * @param calc 숫자를 저장할 클래스.
     */
    public static void inputNumber(StatCalc calc) {

        Scanner sc = new Scanner(System.in);

        double num;
        while ((num = sc.nextDouble()) != 0) {
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
     * 입력이들어온 횟수 , 합 ,최대값 , 최소값.
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
     * 몇개나 입력이 들어왔는지.
     */
    public int getCount() {
        return count;
    }

    /**
     * 총 합.
     */
    public double getSum() {
        return sum;
    }

    /**
     * 평균.
     */
    public double getMean() {
        return sum / count;
    }

    /**
     * 표준편차.
     */
    public double getStandardDeviation() {
        double mean = getMean();
        return Math.sqrt(squareSum / count - mean * mean);
    }

}