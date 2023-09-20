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
        Scanner scanner = new Scanner(System.in);
        int money;

        BlackjackHand player = new BlackjackHand();
        BlackjackHand dealer = new BlackjackHand();
        logger.info("현재 금액 : ");
        money = scanner.nextInt();
        player.setMoney(money);

        do {
            player.clear();
            dealer.clear();

            logger.info("현재 금액을 확인해주세요. 배팅 금액 : ");
            int betMoney = scanner.nextInt();

            if (player.getMoney() < betMoney) {
                continue;
            }
            money = player.getMoney();
            if (playGame(player, dealer, betMoney)) {
                logger.info("you win");
                player.setMoney(money + betMoney);
            } else {
                logger.info("dealer win");
                player.setMoney(money - betMoney);
            }
        } while (player.getMoney() > 0);

        logger.info("수중에 돈이 다 떨어졌습니다. 게임이 종료되었습니다.");
    }

    /**
     * .사용자가 한 게임을 하는 서브루틴
     *
     * @return 사용자가 이기면 true를 반환하고 딜러가 이기면 false를 반환
     */
    private static boolean playGame(BlackjackHand player, BlackjackHand dealer, int betMoney) {
        Card card = new Card();
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        int cardNumber = 2;

        initHand(player, dealer, deck);

        for (int i = 0; i < cardNumber; i++) {
            dealCard(deck, player, card);
            dealCard(deck, dealer, card);
        }
        if (dealer.getBlackjackValue() == WIN_NUMBER) {
            return false;
        } else if (player.getBlackjackValue() == WIN_NUMBER) {
            return true;
        }

        while (true) {
            printCard(player, cardNumber);
            printCard(dealer, 1);

            int choice;
            do {
                logger.info("Enter number (1. stand\t 2. hit)");
                choice = scanner.nextInt();
            } while (choice != 1 && choice != 2);

            if (choice == 1) {
                if (dealer.getBlackjackValue() <= 16) {
                    dealCard(deck, dealer, card);
                    cardNumber++;
                    printCard(dealer, cardNumber);

                    if (dealer.getBlackjackValue() > 21) {
                        return true;
                    } else if (dealer.getBlackjackValue() >= player.getBlackjackValue()) {
                        return false;
                    } else {
                        return true;
                    }
                }
                return false;
            } else if (choice == 2) {
                dealCard(deck, player, card);
                dealCard(deck, dealer, card);

                cardNumber++;
                if (player.getBlackjackValue() > 21) {
                    printCard(player, cardNumber);
                    return false;
                }
            }
        }
    }

    private static void dealCard(Deck deck, BlackjackHand player, Card card) {
        card = deck.dealCard();
        player.addCard(card);
    }

    private static void initHand(BlackjackHand player, BlackjackHand dealer, Deck deck) {
        player.setName("player");
        dealer.setName("dealer");
        deck.shuffle();
    }

    private static void printCard(BlackjackHand hand, int cardNumber) {
        logger.info("{} holds : ", hand.getName());
        for (int i = 0; i < cardNumber; i++) {
            logger.info("{}", hand.getCard(i));
        }
    }
}