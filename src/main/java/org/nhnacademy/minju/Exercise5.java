package org.nhnacademy.minju;

import java.util.Scanner;
import org.nhnacademy.minju.classes.BlackjackHand;
import org.nhnacademy.minju.classes.Card;
import org.nhnacademy.minju.classes.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .Simplified BlackJack
 */
public class Exercise5 {
    private static final Logger logger = LoggerFactory.getLogger(Exercise5.class);
    private static final int WIN_NUMBER = 21;

    /**
     * .run playGame
     */
    public static void exercise5() {
        if (playGame()) {
            logger.info("you win");
        } else {
            logger.info("computer win");
        }
    }

    /**
     * .사용자가 한 게임을 하는 서브루틴
     *
     * @return 사용자가 이기면 true를 반환하고 딜러가 이기면 false를 반환
     */
    private static boolean playGame() {
        Card card;
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        BlackjackHand player = new BlackjackHand();
        BlackjackHand dealer = new BlackjackHand();
        player.setName("player");
        dealer.setName("dealer");
        deck.shuffle();
        int cardNumber = 2;

        for (int i = 0; i < cardNumber; i++) {
            card = deck.dealCard();
            player.addCard(card);
            card = deck.dealCard();
            dealer.addCard(card);
        }
        if (dealer.getBlackjackValue() == WIN_NUMBER) {
            return false;
        } else if (player.getBlackjackValue() == WIN_NUMBER) {
            return true;
        }

        while (true) {
            printCard(player, cardNumber);
            printCard(dealer, cardNumber);

            logger.info("1. stand\t 2. hit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                if (dealer.getBlackjackValue() <= 16) {
                    card = deck.dealCard();
                    dealer.addCard(card);
                    cardNumber++;
                    printCard(dealer, cardNumber);

                    if (dealer.getBlackjackValue() >= 21) {
                        return true;
                    } else if (dealer.getBlackjackValue() >= player.getBlackjackValue()) {
                        return false;
                    } else {
                        return true;
                    }
                }
                return false;
            } else if (choice == 2) {
                card = deck.dealCard();
                player.addCard(card);
                card = deck.dealCard();
                dealer.addCard(card);

                cardNumber++;
                if (player.getBlackjackValue() > 21) {
                    printCard(player, cardNumber);
                    return false;
                }
            }
        }
    }

    private static void printCard(BlackjackHand hand, int cardNumber) {
        logger.info("{} holds : ", hand.getName());
        for (int i = 0; i < cardNumber; i++) {
            logger.info("{}", hand.getCard(i));
        }
    }
}