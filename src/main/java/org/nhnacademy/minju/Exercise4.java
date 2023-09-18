package org.nhnacademy.minju;

import java.util.Random;
import java.util.Scanner;
import org.nhnacademy.minju.classes.BlackjackHand;
import org.nhnacademy.minju.classes.Card;
import org.nhnacademy.minju.classes.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .BlackjackHand 개체와 Deck 개체를 만들어야 합니다. 2와 6 사이의 임의의 숫자를 선택합니다.
 * 데크에서 카드를 그만큼 많이 꺼내서 손에 추가합니다.
 * 손에 있는 모든 카드를 인쇄한 다음 BlackjackValue()를 통해 손에 대해 계산된 값을 인쇄합니다.
 * 사용자가 계속하고 싶어하는 한 이 작업을 반복합니다.
 */
public class Exercise4 {
    private static final Logger logger = LoggerFactory.getLogger(Exercise4.class);

    /**
     * .run blackjack until user ends
     */
    public static void exercise4() {
        Scanner scanner = new Scanner(System.in);
        Card card;
        Deck deck = new Deck();
        Random random = new Random();
        int cardNumber;

        do {
            BlackjackHand blackjackHand = new BlackjackHand();
            deck.shuffle();
            cardNumber = random.nextInt(5) + 2;

            logger.info("you have : ");
            for (int i = 0; i < cardNumber; i++) {
                // Removes the next card from the deck and return it
                card = deck.dealCard();
                // Add a card to the hand.
                blackjackHand.addCard(card);
                logger.info("{}\t", card);
            }
            logger.info("score of deck : {}", blackjackHand.getBlackjackValue());
            logger.info("replay? (y/n)");
        } while (!scanner.nextLine().equals("n"));
    }
}
