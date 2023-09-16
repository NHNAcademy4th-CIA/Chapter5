package org.nhnacademy.lsj;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Problem7 {

    private static final Logger logger = LoggerFactory.getLogger(Problem7.class);

    public static void problem7() {

        IntQuestion[] intQuestions = new IntQuestion[10];

        for (int i = 0; i < 9; i++) {
            do{
                intQuestions[i] = new AdditionQuestion2();
            }while(intQuestions[i].isAnswerMinus());
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
        printQuizResult(intQuestions,answer);

    }

    public static int[] setInputAnswer(IntQuestion[] intQuestion) {

        Scanner sc = new Scanner(System.in);

        int answer[] = new int[10];


        for (int i = 0; i < intQuestion.length; i++) {
            logger.info("{}", intQuestion[i].getQuestion());
            answer[i] = sc.nextInt();
        }
        return answer;
    }

    public static void printQuizResult(IntQuestion[] intQuestions, int[] answer) {

        for (int i = 0; i < intQuestions.length; i++) {
            if (intQuestions[i].getCorrectAnswer() == answer[i]) {
                logger.info("정답입니다");
                continue;
            }
            logger.info("{}번쨰 질문 오답입니다 정답 {}",i+1,intQuestions[i].getCorrectAnswer());
        }

    }


}

class AdditionQuestion2 implements IntQuestion {

    private int a, b;  // The numbers in the problem.

    public AdditionQuestion2() { // constructor
        a = (int) (Math.random() * 50 + 1);
        b = (int) (Math.random() * 50);
    }


    @Override
    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";

    }

    @Override
    public int getCorrectAnswer() {
        return a - b;
    }

    @Override
    public boolean isAnswerMinus() {
        return this.a - this.b < 0;
    }

}

interface IntQuestion {
    public String getQuestion();

    public int getCorrectAnswer();

    public boolean isAnswerMinus();
}

