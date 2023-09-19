package org.nhnacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quiz3 {
    Logger logger = LoggerFactory.getLogger(Quiz3.class);
    private static final int loop = 10_000;
    public Quiz3(){
        for (int i=2;i<=12;i+=2) {
            StatCalc statCalc = new StatCalc();
            for (int j = 0; j < loop; j++) {
                PairOfDice pairOfDice = new PairOfDice();
                statCalc.enter(pairOfDice.hasPair(i));
            }
            logger.info("{}의 평균 {}",i,statCalc.getMean());
            logger.info("{}의 최대 {}",i,statCalc.getMax());
            logger.info("{}의 표준편차 {}",i,statCalc.getStandardDeviation());
        }

    }

}
//
//class PairOfDice {
//
//    private int die1;
//    private int die2;
//    private int count;
//
//    public PairOfDice() {
//        roll();
//        count = 0;
//    }
//
//    /***
//     * 주사위를 던지는 메소드.
//     */
//    public void roll() {
//        // Roll the dice by setting each of the dice to be
//        // a random number between 1 and 6.
//        die1 = (int) (Math.random() * 6) + 1;
//        die2 = (int) (Math.random() * 6) + 1;
//        count++;
//    }
//
//    /***
//     * snakeEye를 가질때까지 반복하는 메소드
//     */
//    public void hasSnakeEyes() {
//        while (!isPair(2)) {
//            roll();
//        }
//    }
//
//    /***
//     * pair인지 확인 하는 메소드
//     * @param  페어 번호
//     * @return 페어가 맞으면 true
//     */
//    public boolean isPair(int number) {
//        return die1 + die2 == number;
//    }
//
//    @Override
//    public String toString() {
//        return "snakeEyes가 되기 위해 주사위를 총 " + count + "번 던졌습니다.";
//    }
//}
//class StatCalc {
//
//    private int count;
//    private double sum;
//    private double squareSum;
//    private double max = 0;
//    private double min = 0;
//
//    /***
//     * 입력 메소드
//     * @param num 입력 숫자
//     */
//    public void enter(double num) {
//        if (isZero(num)) return;
//        if (min == 0) {
//            min = num;
//            max = num;
//        }
//        sum += num;
//        squareSum += num * num;
//        if (num < min) {
//            min = num;
//        }
//        if (num > max) {
//            max = num;
//        }
//        count++;
//    }
//
//    /***
//     * 입력 횟수
//     * @return 입력 횟수
//     */
//    public int getCount() {
//        return count;
//    }
//
//    /***
//     * 합계
//     * @return 합계
//     */
//    public double getSum() {
//        return sum;
//    }
//
//    /***
//     * 평균
//     * @return 평균
//     */
//    public double getMean() {
//        return sum / count;
//    }
//
//    /***
//     * 표준 편차
//     * @return 표준 편차
//     */
//    public double getStandardDeviation() {
//        double mean = getMean();
//        return Math.sqrt(squareSum / count - mean * mean);
//    }
//
//
//    /***
//     * 최대값
//     * @return
//     */
//    public double getMax() {
//        return max;
//    }
//
//    /***
//     * 최소값
//     * @return 최소값
//     */
//    public double getMin() {
//        return min;
//    }
//
//    /***
//     * 입력 값이 0인지
//     * @param num 입력 값
//     * @return 0이면 true
//     */
//    public boolean isZero(double num) {
//        return num == 0;
//    }
//}