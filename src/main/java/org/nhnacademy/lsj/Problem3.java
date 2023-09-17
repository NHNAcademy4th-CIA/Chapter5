package org.nhnacademy.lsj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem2를 이용해 진행 , 10000번의 주사위를 던짐.
 */
public class Problem3 {

    private static final Logger logger = LoggerFactory.getLogger(Problem3.class);

    /**
     * 프로그램이 진행됨.
     */
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
            printStat(calc[i], i);
        }

    }

    /**
     * calc 배열을 초기호함.
     *
     * @param calc 주사위 2~12까지의 calc배열.
     */
    public static void initStatCalc(StatCalc[] calc) {
        for (int i = 0; i < calc.length; i++) {
            calc[i] = new StatCalc();
        }
    }

    /**
     * 평균, 편차 , 최대 롤수 출력.
     *
     * @param calc  연산이 일어나는 클래스.
     * @param index 숫자 가 몇번인지.
     */
    public static void printStat(StatCalc calc, int index) {

        logger.info("숫자 {} 평균 롤 횟수 {}", index, calc.getMean());
        logger.info("숫자 {} 표준 롤 편차는 {}", index, calc.getStandardDeviation());
        logger.info("숫자 {} 최대 롤수는 {}\n", index, calc.getMaxValue());

    }

    /**
     * 주사위를 돌린다.
     *
     * @param num 목표 값.
     * @return num을 뽑기까지 돌린 횟수.
     */
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
