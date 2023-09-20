package org.nhnacademy.minju;

import java.util.Random;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .Write a similar class to represent subtraction questions.
 * When creating a subtraction problem, you should make sure that the answer is not negative.
 */
public class Exercise7 {
    private static final Logger logger = LoggerFactory.getLogger(Exercise7.class);
    private static IntQuestion[] questions;
    private static int[] userAnswers;

    /**
     * .run quiz
     */
    public static void exercise7() {

        createQuiz();
        administerQuiz();
        gradeQuiz();

        IntQuestion bigQuestion = new IntQuestion() {
            public String getQuestion() {
                return "What is the answer to the ultimate question "
                        + " of life, the universe, and everything?";
            }

            public int getCorrectAnswer() {
                return 42;
            }
        };
        logger.info("big question : {}", bigQuestion.getQuestion());
        logger.info("answer : {}", bigQuestion.getCorrectAnswer());
    }

    /**
     * Creates the arrays that hold the numbers for the questions and fills
     * them with random numbers.
     */
    private static void createQuiz() {
        questions = new IntQuestion[10];
        for (int i = 0; i < 10; i++) {
            questions[i] = new SubtractionQuestion();
        }
    }

    /**
     * Asks the user each of the ten quiz questions and gets the user's answers.
     * The answers are stored in an array, which is created in this subroutine.
     */
    private static void administerQuiz() {
        Scanner scanner = new Scanner(System.in);
        userAnswers = new int[10];
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            logger.info("{}. {}",
                    questionNum, questions[i].getQuestion());
            userAnswers[i] = scanner.nextInt();
        }
    }


    /**
     * Shows all the questions, with their correct answers, and computes a grade
     * for the quiz.  For each question, the user is told whether they got
     * it right.
     */
    private static void gradeQuiz() {
        logger.info("Here are the correct answers:");
        int numberCorrect = 0;
        int grade;
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            int correctAnswer = questions[i].getCorrectAnswer();
            logger.info("{}. {}", questionNum, questions[i].getQuestion());
            if (userAnswers[i] == correctAnswer) {
                logger.info("You were CORRECT.");
                numberCorrect++;
            } else {
                logger.info("You said {}, which is INCORRECT.", userAnswers[i]);
            }
        }
        grade = numberCorrect * 10;
        logger.info("You got {} questions correct.", numberCorrect);
        logger.info("Your grade on the quiz is {}", grade);
    }


}

class SubtractionQuestion implements IntQuestion {
    private int num1;
    private int num2;

    public SubtractionQuestion() {
        Random random = new Random();
        do {
            num1 = random.nextInt(51);
            num2 = random.nextInt(50);
        } while (num1 - num2 < 0);
    }

    @Override
    public String getQuestion() {
        return "What is " + num1 + " - " + num2 + "?";
    }

    @Override
    public int getCorrectAnswer() {
        return num1 - num2;
    }
}