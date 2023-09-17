package org.nhnacademy.lsj.blackJack;

/**
 * 핸드를 포함하는 클래스.
 */
public class BlackJackHand {


    /**
     * Computes and returns the value of this hand in the game
     * of Blackjack.
     */

    private final Hand hand;

    public int getMoney() {
        return money;
    }

    public void clear() {
        hand.clear();
    }

    private int money;

    public BlackJackHand() {
        hand = new Hand();
        money = 100;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void minusMoney(int money) {
        this.money -= money;
    }

    public void add(Card card) {
        hand.addCard(card);
    }

    public void printHand() {
        hand.printHand();
    }

    public void printHandByIndex(int index) {
        hand.printHandByIndex(index);
    }

    public void handClear() {
        hand.clear();
    }

    public boolean isEnoughMoney() {
        return this.money > 0;
    }

    /**
     * 손패의 합을 리턴함.
     *
     * @return 손패의합.
     */
    public int getBlackjackValue() {

        int val;      // The value computed for the hand.
        boolean ace;  // This will be set to true if the
        //   hand contains an ace.
        int cards;    // Number of cards in the hand.

        val = 0;
        ace = false;


        cards = hand.getCardCount();  // (method defined in class Hand.)

        for (int i = 0; i < cards; i++) {
            // Add the value of the i-th card in the hand.
            Card card;    // The i-th card;
            int cardVal;  // The blackjack value of the i-th card.
            card = hand.getCard(i);
            cardVal = card.getValue();  // The normal value, 1 to 13.
            if (cardVal > 10) {
                cardVal = 10;   // For a Jack, Queen, or King.
            }
            if (cardVal == 1) {
                ace = true;     // There is at least one ace.
            }
            val = val + cardVal;
        }

        // Now, val is the value of the hand, counting any ace as 1.
        // If there is an ace, and if changing its value from 1 to
        // 11 would leave the score less than or equal to 21,
        // then do so by adding the extra 10 points to val.

        if (ace == true && val + 10 <= 21) {
            val = val + 10;
        }

        return val;

    }  // end getBlackjackValue()

} // end class BlackjackHand
