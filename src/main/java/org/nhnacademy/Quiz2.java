package org.nhnacademy;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Quiz2 statCalc구현
 */
public class Quiz2 {
    Scanner scanner = new Scanner(System.in);
    Logger logger = LoggerFactory.getLogger(Quiz2.class);

    public Quiz2() {
        StatCalc statCalc = new StatCalc();
        double value;
        while (!statCalc.isZero(value = scanner.nextDouble())) {
            statCalc.enter(value);
        }
        logger.info("추가된 카운트 수는{}", statCalc.getCount());
        logger.info("합계 {}", statCalc.getSum());
        logger.info("평균 {}", statCalc.getMean());
        logger.info("표준 편차 {}", statCalc.getStandardDeviation());
        logger.info("제일 큰 값{}", statCalc.getMax());
        logger.info("제일 작은 값{}", statCalc.getMin());
    }
}

/***
 * 입력횟수
 * 최대값
 * 최솟값
 * 평균
 * 합계
 * 표준 편차
 */
class StatCalc {

    private int count;
    private double sum;
    private double squareSum;
    private double max = 0;
    private double min = 0;

    /***
     * 입력 메소드
     * @param num 입력 숫자
     */
    public void enter(double num) {
        if (isZero(num)) return;
        if (min == 0) {
            min = num;
            max = num;
        }
        sum += num;
        squareSum += num * num;
        min=Math.min(min,num);
        max=Math.max(max,num);
    }

    /***
     * 입력 횟수
     * @return 입력 횟수
     */
    public int getCount() {
        return count;
    }

    /***
     * 합계
     * @return 합계
     */
    public double getSum() {
        return sum;
    }

    /***
     * 평균
     * @return 평균
     */
    public double getMean() {
        return sum / count;
    }

    /***
     * 표준 편차
     * @return 표준 편차
     */
    public double getStandardDeviation() {
        double mean = getMean();
        return Math.sqrt(squareSum / count - mean * mean);
    }


    /***
     * 최대값
     * @return
     */
    public double getMax() {
        return max;
    }

    /***
     * 최소값
     * @return 최소값
     */
    public double getMin() {
        return min;
    }

    /***
     * 입력 값이 0인지
     * @param num 입력 값
     * @return 0이면 true
     */
    public boolean isZero(double num) {
        return num == 0;
    }
}