package org.nhnacademy.minju;

import java.util.Scanner;
import org.nhnacademy.minju.classes.AdditionQuestion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .Rewrite that program so that it uses the following class to represent addition questions
 */
public class Exercise6 {
    private static final Logger logger = LoggerFactory.getLogger(Exercise6.class);
    private static AdditionQuestion[] additionQuestion;
    private static int[] userAnswers;

    /**
     * .run quiz
     */
    public static void exercise6() {
        createQuiz();
        administerQuiz();
        gradeQuiz();
    }

    /**
     * Creates the arrays that hold the numbers for the questions and fills
     * them with random numbers.
     */
    private static void createQuiz() {
        additionQuestion = new AdditionQuestion[10];
        for (int i = 0; i < 10; i++) {
            additionQuestion[i] = new AdditionQuestion();
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
                    questionNum, additionQuestion[i].getQuestion());
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
            int correctAnswer = additionQuestion[i].getCorrectAnswer();
            logger.info("{}. {}", questionNum, additionQuestion[i].getQuestion());
            if (userAnswers[i] == correctAnswer) {
                logger.info("You were CORRECT.");
                numberCorrect++;
                continue;
            }
            logger.info("You said {}, which is INCORRECT.", userAnswers[i]);
        }
        grade = numberCorrect * 10;
        logger.info("You got {} questions correct.", numberCorrect);
        logger.info("Your grade on the quiz is {}", grade);
    }

} // end class AdditionQuiz