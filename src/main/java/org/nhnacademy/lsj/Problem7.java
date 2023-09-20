package org.nhnacademy.lsj;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Problem6의 문제를 Interface를 추가해 다시 작성함.
 */
public class Problem7 {

    private static final Logger logger = LoggerFactory.getLogger(Problem7.class);

    /**
     * 프로그램 진행.
     */
    public static void problem7() {

        IntQuestion[] intQuestions = new IntQuestion[10];

        for (int i = 0; i < 9; i++) {
            do {
                intQuestions[i] = new AdditionQuestion2();
            } while (intQuestions[i].isAnswerMinus());
        }

        IntQuestion bigQuestion = new IntQuestion() {
            public String getQuestion() {
                return "이 프로그램 작성자의 나이는?";
            }

            public int getCorrectAnswer() {
                return 25;
            }

            @Override
            public boolean isAnswerMinus() {
                return false;
            }
        };

        intQuestions[9] = bigQuestion;

        int[] answer = setInputAnswer(intQuestions);
        printQuizResult(intQuestions, answer);

    }

    /**
     * 사용자에게 퀴즈를 내고 정답을 입력받음.
     *
     * @param intQuestion 질문 .
     * @return 사용자 정답 배열.
     */
    public static int[] setInputAnswer(IntQuestion[] intQuestion) {

        Scanner sc = new Scanner(System.in);

        int[] answer = new int[10];


        for (int i = 0; i < intQuestion.length; i++) {
            logger.info("{}", intQuestion[i].getQuestion());
            answer[i] = sc.nextInt();
        }
        return answer;
    }

    /**
     * 퀴즈 결과를 출력함.
     *
     * @param intQuestions 퀴즈.
     * @param answer       사용자 정답.
     */
    public static void printQuizResult(IntQuestion[] intQuestions, int[] answer) {

        for (int i = 0; i < intQuestions.length; i++) {
            if (intQuestions[i].getCorrectAnswer() == answer[i]) {
                logger.info("정답입니다");
                continue;
            }
            logger.info("{}번쨰 질문 오답입니다 정답 {}", i + 1, intQuestions[i].getCorrectAnswer());
        }

    }


}

class AdditionQuestion2 implements IntQuestion {

    private int num1;
    private int num2;  // The numbers in the problem.

    public AdditionQuestion2() { // constructor
        num1 = (int) (Math.random() * 50 + 1);
        num2 = (int) (Math.random() * 50);
    }


    @Override
    public String getQuestion() {
        return "What is " + num1 + " - " + num2 + " ?";

    }

    @Override
    public int getCorrectAnswer() {
        return num1 - num2;
    }

    @Override
    public boolean isAnswerMinus() {
        return this.num1 - this.num2 < 0;
    }

}

interface IntQuestion {
    public String getQuestion();

    public int getCorrectAnswer();

    public boolean isAnswerMinus();
}

