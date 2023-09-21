package org.nhnacademy;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Quiz7 -적용
 */
public class Quiz7 {
    private Logger logger = LoggerFactory.getLogger(Quiz7.class);
    private Scanner scanner = new Scanner(System.in);

    public Quiz7() {
        IntQuestion bigQuestion = new IntQuestion() {
            public String getQuestion() {
                return "What is the answer to the ultimate question " +
                        " of life, the universe, and everything?";
            }
            public int getCorrectAnswer() {
                return 42;
            }
        };
        int answer = 0;
        logger.info(bigQuestion.getQuestion());
        if(bigQuestion.getCorrectAnswer()==scanner.nextInt())
        {
            answer+=10;
        }
        for (int i = 0; i < 9; i++) {
            if(i%2==0)
            {
                SubQuestion subQuestion = new SubQuestion();
                logger.info(subQuestion.getQuestion());
                if(subQuestion.getCorrectAnswer()==scanner.nextInt()){
                    answer+=10;
                }
                continue;
            }
            AdditionQuestion additionQuestion = new AdditionQuestion();
            logger.info(additionQuestion.getQuestion());
            if (additionQuestion.getCorrectAnswer() == scanner.nextInt()) {
                answer += 10;
            }
        }
        logger.info("당신의 점수는 ? {}", answer);
    }
}
interface IntQuestion {
    public String getQuestion();
    public int getCorrectAnswer();
}

/***
 * 질문 클래스
 */
class SubQuestion implements IntQuestion{

    private int a, b;  // The numbers in the problem.

    public SubQuestion() { // constructor
        a = (int) (Math.random() * 50 + 1);
        b = (int) (Math.random() * 50);
    }


    /***
     * 질문?
     * @return 질문
     */
    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";
    }

    /***
     * 정답 비교
     * @return 정답
     */
    public int getCorrectAnswer() {
        return a - b;
    }

}