package org.nhnacademy.lsj;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Problem6 {
    private static final Logger logger = LoggerFactory.getLogger(Problem6.class);

    public static void problem6() {

        AdditionQuestion[] question = getQuizArray();
        int[] answer = getAnswerArray(question);
        printQuizResult(question, answer);

    }

    public static void printQuizResult(AdditionQuestion[] question, int[] answer) { // 퀴즈 결과 출력
        int count = 0;
        for (int i = 0; i < question.length; i++) {
            if (question[i].getCorrectAnswer() == answer[i]) {
                logger.info("{}번 문제 정답입니다.", i + 1);
                count++;
                continue;
            }
            logger.info("{}번 문제 틀렸습니다. 정답은 {}입니다.", i + 1, question[i].getCorrectAnswer());
        }
        logger.info("최종 점수는 {}점 입니다.", count*10);
    }

    public static AdditionQuestion[] getQuizArray() { // 퀴즈 배열 생성
        AdditionQuestion[] quizs = new AdditionQuestion[10];

        for (int i = 0; i < 10; i++) {
            quizs[i] = new AdditionQuestion(); // 생성자 통해서 알아서 만들어짐
        }
        return quizs;
    }


    public static int[] getAnswerArray(AdditionQuestion[] question) { // 사용자가 퀴즈 정답 입력
        Scanner sc = new Scanner(System.in);

        int[] answer = new int[10];

        for (int i = 0; i < question.length; i++) {
            logger.info("{}", question[i].getQuestion());
            answer[i] = sc.nextInt();
        }
        return answer;
    }
}


class AdditionQuestion {

    private int a, b;  // The numbers in the problem.

    public AdditionQuestion() { // constructor
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
    }

    public String getQuestion() {
        return "What is " + a + " + " + b + " ?";
    }

    public int getCorrectAnswer() {
        return a + b;
    }

}