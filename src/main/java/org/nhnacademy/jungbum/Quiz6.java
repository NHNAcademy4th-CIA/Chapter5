package org.nhnacademy.jungbum;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Quiz6 전에 만든 수학문제 풀기 개선
 */
public class Quiz6 {
    private Logger logger = LoggerFactory.getLogger(Quiz6.class);
    private Scanner scanner = new Scanner(System.in);

    public Quiz6() {
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            AdditionQuestion additionQuestion = new AdditionQuestion();
            logger.info(additionQuestion.getQuestion());
            if (additionQuestion.getCorrectAnswer() == scanner.nextInt()) {
                answer += 10;
            }
        }
        logger.info("당신의 점수는 ? {}", answer);
    }
}

/***
 * 더하기 질문 클래스
 */
class AdditionQuestion implements IntQuestion{

    private int a, b;  // The numbers in the problem.

    public AdditionQuestion() { // constructor
        a = (int) (Math.random() * 50 + 1);
        b = (int) (Math.random() * 50);
    }


    /***
     * 질문?
     * @return 질문
     */
    public String getQuestion() {
        return "What is " + a + " + " + b + " ?";
    }

    /***
     * 정답 비교
     * @return 정답
     */
    public int getCorrectAnswer() {
        return a + b;
    }

}