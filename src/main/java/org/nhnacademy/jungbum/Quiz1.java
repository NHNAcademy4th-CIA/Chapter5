package org.nhnacademy.jungbum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Quiz1 snakeEye만들기 private, toString
 */
public class Quiz1 {
    Logger logger = LoggerFactory.getLogger(Quiz1.class);

    public Quiz1() {
        PairOfDice pairOfDice = new PairOfDice();
        pairOfDice.hasPair(2);
        logger.info("{}", pairOfDice);
    }


}

/***
 * 주사위를 페어로 제어하는 클래스
 */
class PairOfDice {

    private int die1;
    private int die2;
    private int count;

    public PairOfDice() {
        roll();
        count = 0;
    }

    /***
     * 주사위를 던지는 메소드.
     */
    public void roll() {
        // Roll the dice by setting each of the dice to be
        // a random number between 1 and 6.
        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
        count++;
    }

    /**
     * pair가 나올떼까지 주사위 돌리는 메소드
     *
     * @param num 원하는숫자
     * @return 몇번 굴렸는지
     */
    public int hasPair(int num) {
        count = 0;
        while (!isPair(num)) {
            count++;
            roll();
        }
        return count;
    }

    /***
     * pair인지 확인 하는 메소드
     * @param  페어 번호
     * @return 페어가 맞으면 true
     */
    public boolean isPair(int number) {
        return die1 + die2 == number && die1 == die2;
    }

    @Override
    public String toString() {
        return "snakeEyes가 되기 위해 주사위를 총 " + count + "번 던졌습니다.";
    }
}