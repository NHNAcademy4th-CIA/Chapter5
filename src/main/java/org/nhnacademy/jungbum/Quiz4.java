//package org.nhnacademy;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Quiz4 {
//    Logger logger = LoggerFactory.getLogger(Quiz4.class);
//
//    private int money;
//    private int bet;
//    private boolean userWins;
//    Scanner scanner = new Scanner(System.in);
//    public Quiz4(){
//        money = 100;
//
//        while (true) {
//            logger.info("남은돈 {}",money);
//            do {
//                logger.info("배팅 끝내고싶으면 0 ? ");
//                bet = scanner.nextInt();
//                if (bet < 0 || bet > money)
//                    logger.info("너는 0부터 {}까지의 돈만 입력할수있다.",money);
//            } while (bet < 0 || bet > money);
//            if (bet == 0)
//                break;
//            userWins = playBlackjack();
//            if (userWins)
//                money = money + bet;
//            else
//                money = money - bet;
//            if (money == 0) {
//                logger.info("돈 을 전부 잃음");
//                break;
//            }
//        }
//
//       logger.info("상금 $ {}", money);
//    }
//    static boolean playBlackjack() {
//
//        Deck deck;                  // A deck of cards.  A new deck for each game.
//        BlackjackHand dealerHand;   // The dealer's hand.
//        BlackjackHand userHand;     // The user's hand.
//
//        deck = new Deck();
//        dealerHand = new BlackjackHand();
//        userHand = new BlackjackHand();
//
//        /*  Shuffle the deck, then deal two cards to each player. */
//
//        deck.shuffle();
//        dealerHand.addCard( deck.dealCard() );
//        dealerHand.addCard( deck.dealCard() );
//        userHand.addCard( deck.dealCard() );
//        userHand.addCard( deck.dealCard() );
//
//        System.out.println();
//        System.out.println();
//
//      /* Check if one of the players has Blackjack (two cards totaling to 21).
//         The player with Blackjack wins the game.  Dealer wins ties.
//      */
//
//        if (dealerHand.getBlackjackValue() == 21) {
//            System.out.println("Dealer has the " + dealerHand.getCard(0)
//                    + " and the " + dealerHand.getCard(1) + ".");
//            System.out.println("User has the " + userHand.getCard(0)
//                    + " and the " + userHand.getCard(1) + ".");
//            System.out.println();
//            System.out.println("Dealer has Blackjack.  Dealer wins.");
//            return false;
//        }
//
//        if (userHand.getBlackjackValue() == 21) {
//            System.out.println("Dealer has the " + dealerHand.getCard(0)
//                    + " and the " + dealerHand.getCard(1) + ".");
//            System.out.println("User has the " + userHand.getCard(0)
//                    + " and the " + userHand.getCard(1) + ".");
//            System.out.println();
//            System.out.println("You have Blackjack.  You win.");
//            return true;
//        }
//
//      /*  If neither player has Blackjack, play the game.  First the user
//          gets a chance to draw cards (i.e., to "Hit").  The while loop ends
//          when the user chooses to "Stand".  If the user goes over 21,
//          the user loses immediately.
//      */
//
//        while (true) {
//
//            /* Display user's cards, and let user decide to Hit or Stand. */
//
//            System.out.println();
//            System.out.println();
//            System.out.println("Your cards are:");
//            for ( int i = 0; i < userHand.getCardCount(); i++ )
//                System.out.println("    " + userHand.getCard(i));
//            System.out.println("Your total is " + userHand.getBlackjackValue());
//            System.out.println();
//            System.out.println("Dealer is showing the " + dealerHand.getCard(0));
//            System.out.println();
//            System.out.print("Hit (H) or Stand (S)? ");
//            char userAction;  // User's response, 'H' or 'S'.
//            do {
//                userAction = Character.toUpperCase( scanner.next() );
//                if (userAction != 'H' && userAction != 'S')
//                    System.out.print("Please respond H or S:  ");
//            } while (userAction != 'H' && userAction != 'S');
//
//           /* If the user Hits, the user gets a card.  If the user Stands,
//              the loop ends (and it's the dealer's turn to draw cards).
//           */
//
//            if ( userAction == 'S' ) {
//                // Loop ends; user is done taking cards.
//                break;
//            }
//            else {  // userAction is 'H'.  Give the user a card.
//                // If the user goes over 21, the user loses.
//                Card newCard = deck.dealCard();
//                userHand.addCard(newCard);
//                System.out.println();
//                System.out.println("User hits.");
//                System.out.println("Your card is the " + newCard);
//                System.out.println("Your total is now " + userHand.getBlackjackValue());
//                if (userHand.getBlackjackValue() > 21) {
//                    System.out.println();
//                    System.out.println("You busted by going over 21.  You lose.");
//                    System.out.println("Dealer's other card was the "
//                            + dealerHand.getCard(1));
//                    return false;
//                }
//            }
//
//        } // end while loop
//
//      /* If we get to this point, the user has Stood with 21 or less.  Now, it's
//         the dealer's chance to draw.  Dealer draws cards until the dealer's
//         total is > 16.  If dealer goes over 21, the dealer loses.
//      */
//
//        System.out.println();
//        System.out.println("User stands.");
//        System.out.println("Dealer's cards are");
//        System.out.println("    " + dealerHand.getCard(0));
//        System.out.println("    " + dealerHand.getCard(1));
//        while (dealerHand.getBlackjackValue() <= 16) {
//            Card newCard = deck.dealCard();
//            System.out.println("Dealer hits and gets the " + newCard);
//            dealerHand.addCard(newCard);
//            if (dealerHand.getBlackjackValue() > 21) {
//                System.out.println();
//                System.out.println("Dealer busted by going over 21.  You win.");
//                return true;
//            }
//        }
//        System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());
//
//      /* If we get to this point, both players have 21 or less.  We
//         can determine the winner by comparing the values of their hands. */
//
//        System.out.println();
//        if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
//            System.out.println("Dealer wins on a tie.  You lose.");
//            return false;
//        }
//        else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
//            System.out.println("Dealer wins, " + dealerHand.getBlackjackValue()
//                    + " points to " + userHand.getBlackjackValue() + ".");
//            return false;
//        }
//        else {
//            System.out.println("You win, " + userHand.getBlackjackValue()
//                    + " points to " + dealerHand.getBlackjackValue() + ".");
//            return true;
//        }
//
//    }  // end playBlackjack()
//
//
//} // end class Blackjack
//}
///**
// * An object of type Card represents a playing card from a
// * standard Poker deck, including Jokers.  The card has a suit, which
// * can be spades, hearts, diamonds, clubs, or joker.  A spade, heart,
// * diamond, or club has one of the 13 values: ace, 2, 3, 4, 5, 6, 7,
// * 8, 9, 10, jack, queen, or king.  Note that "ace" is considered to be
// * the smallest value.  A joker can also have an associated value;
// * this value can be anything and can be used to keep track of several
// * different jokers.
// */
//class Card {
//
//    public final static int SPADES = 0;   // Codes for the 4 suits, plus Joker.
//    public final static int HEARTS = 1;
//    public final static int DIAMONDS = 2;
//    public final static int CLUBS = 3;
//    public final static int JOKER = 4;
//
//    public final static int ACE = 1;      // Codes for the non-numeric cards.
//    public final static int JACK = 11;    //   Cards 2 through 10 have their
//    public final static int QUEEN = 12;   //   numerical values for their codes.
//    public final static int KING = 13;
//
//    /**
//     * This card's suit, one of the constants SPADES, HEARTS, DIAMONDS,
//     * CLUBS, or JOKER.  The suit cannot be changed after the card is
//     * constructed.
//     */
//    private final int suit;
//
//    /**
//     * The card's value.  For a normal card, this is one of the values
//     * 1 through 13, with 1 representing ACE.  For a JOKER, the value
//     * can be anything.  The value cannot be changed after the card
//     * is constructed.
//     */
//    private final int value;
//
//    /**
//     * Creates a Joker, with 1 as the associated value.  (Note that
//     * "new Card()" is equivalent to "new Card(1,Card.JOKER)".)
//     */
//    public Card() {
//        suit = JOKER;
//        value = 1;
//    }
//
//    /**
//     * Creates a card with a specified suit and value.
//     * @param theValue the value of the new card.  For a regular card (non-joker),
//     * the value must be in the range 1 through 13, with 1 representing an Ace.
//     * You can use the constants Card.ACE, Card.JACK, Card.QUEEN, and Card.KING.
//     * For a Joker, the value can be anything.
//     * @param theSuit the suit of the new card.  This must be one of the values
//     * Card.SPADES, Card.HEARTS, Card.DIAMONDS, Card.CLUBS, or Card.JOKER.
//     * @throws IllegalArgumentException if the parameter values are not in the
//     * permissible ranges
//     */
//    public Card(int theValue, int theSuit) {
//        if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS &&
//                theSuit != CLUBS && theSuit != JOKER)
//            throw new IllegalArgumentException("Illegal playing card suit");
//        if (theSuit != JOKER && (theValue < 1 || theValue > 13))
//            throw new IllegalArgumentException("Illegal playing card value");
//        value = theValue;
//        suit = theSuit;
//    }
//
//    /**
//     * Returns the suit of this card.
//     * @returns the suit, which is one of the constants Card.SPADES,
//     * Card.HEARTS, Card.DIAMONDS, Card.CLUBS, or Card.JOKER
//     */
//    public int getSuit() {
//        return suit;
//    }
//
//    /**
//     * Returns the value of this card.
//     * @return the value, which is one of the numbers 1 through 13, inclusive for
//     * a regular card, and which can be any value for a Joker.
//     */
//    public int getValue() {
//        return value;
//    }
//
//    /**
//     * Returns a String representation of the card's suit.
//     * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs"
//     * or "Joker".
//     */
//    public String getSuitAsString() {
//        switch ( suit ) {
//            case SPADES:   return "Spades";
//            case HEARTS:   return "Hearts";
//            case DIAMONDS: return "Diamonds";
//            case CLUBS:    return "Clubs";
//            default:       return "Joker";
//        }
//    }
//
//    /**
//     * Returns a String representation of the card's value.
//     * @return for a regular card, one of the strings "Ace", "2",
//     * "3", ..., "10", "Jack", "Queen", or "King".  For a Joker, the
//     * string is always numerical.
//     */
//    public String getValueAsString() {
//        if (suit == JOKER)
//            return "" + value;
//        else {
//            switch ( value ) {
//                case 1:   return "Ace";
//                case 2:   return "2";
//                case 3:   return "3";
//                case 4:   return "4";
//                case 5:   return "5";
//                case 6:   return "6";
//                case 7:   return "7";
//                case 8:   return "8";
//                case 9:   return "9";
//                case 10:  return "10";
//                case 11:  return "Jack";
//                case 12:  return "Queen";
//                default:  return "King";
//            }
//        }
//    }
//
//    /**
//     * Returns a string representation of this card, including both
//     * its suit and its value (except that for a Joker with value 1,
//     * the return value is just "Joker").  Sample return values
//     * are: "Queen of Hearts", "10 of Diamonds", "Ace of Spades",
//     * "Joker", "Joker #2"
//     */
//    public String toString() {
//        if (suit == JOKER) {
//            if (value == 1)
//                return "Joker";
//            else
//                return "Joker #" + value;
//        }
//        else
//            return getValueAsString() + " of " + getSuitAsString();
//    }
//
//
//} // end class Card
//
///**
// *  An object of type Deck represents a deck of playing cards.  The deck
// *  is a regular poker deck that contains 52 regular cards and that can
// *  also optionally include two Jokers.
// */
//class Deck {
//
//    /**
//     * An array of 52 or 54 cards.  A 54-card deck contains two Jokers,
//     * in addition to the 52 cards of a regular poker deck.
//     */
//    private Card[] deck;
//
//    /**
//     * Keeps track of the number of cards that have been dealt from
//     * the deck so far.
//     */
//    private int cardsUsed;
//
//    /**
//     * Constructs a regular 52-card poker deck.  Initially, the cards
//     * are in a sorted order.  The shuffle() method can be called to
//     * randomize the order.  (Note that "new Deck()" is equivalent
//     * to "new Deck(false)".)
//     */
//    public Deck() {
//        this(false);  // Just call the other constructor in this class.
//    }
//
//    /**
//     * Constructs a poker deck of playing cards, The deck contains
//     * the usual 52 cards and can optionally contain two Jokers
//     * in addition, for a total of 54 cards.   Initially the cards
//     * are in a sorted order.  The shuffle() method can be called to
//     * randomize the order.
//     * @param includeJokers if true, two Jokers are included in the deck; if false,
//     * there are no Jokers in the deck.
//     */
//    public Deck(boolean includeJokers) {
//        if (includeJokers)
//            deck = new Card[54];
//        else
//            deck = new Card[52];
//        int cardCt = 0; // How many cards have been created so far.
//        for ( int suit = 0; suit <= 3; suit++ ) {
//            for ( int value = 1; value <= 13; value++ ) {
//                deck[cardCt] = new Card(value,suit);
//                cardCt++;
//            }
//        }
//        if (includeJokers) {
//            deck[52] = new Card(1,Card.JOKER);
//            deck[53] = new Card(2,Card.JOKER);
//        }
//        cardsUsed = 0;
//    }
//
//    /**
//     * Put all the used cards back into the deck (if any), and
//     * shuffle the deck into a random order.
//     */
//    public void shuffle() {
//        for ( int i = deck.length-1; i > 0; i-- ) {
//            int rand = (int)(Math.random()*(i+1));
//            Card temp = deck[i];
//            deck[i] = deck[rand];
//            deck[rand] = temp;
//        }
//        cardsUsed = 0;
//    }
//
//    /**
//     * As cards are dealt from the deck, the number of cards left
//     * decreases.  This function returns the number of cards that
//     * are still left in the deck.  The return value would be
//     * 52 or 54 (depending on whether the deck includes Jokers)
//     * when the deck is first created or after the deck has been
//     * shuffled.  It decreases by 1 each time the dealCard() method
//     * is called.
//     */
//    public int cardsLeft() {
//        return deck.length - cardsUsed;
//    }
//
//    /**
//     * Removes the next card from the deck and return it.  It is illegal
//     * to call this method if there are no more cards in the deck.  You can
//     * check the number of cards remaining by calling the cardsLeft() function.
//     * @return the card which is removed from the deck.
//     * @throws IllegalStateException if there are no cards left in the deck
//     */
//    public Card dealCard() {
//        if (cardsUsed == deck.length)
//            throw new IllegalStateException("No cards are left in the deck.");
//        cardsUsed++;
//        return deck[cardsUsed - 1];
//        // Programming note:  Cards are not literally removed from the array
//        // that represents the deck.  We just keep track of how many cards
//        // have been used.
//    }
//
//    /**
//     * Test whether the deck contains Jokers.
//     * @return true, if this is a 54-card deck containing two jokers, or false if
//     * this is a 52 card deck that contains no jokers.
//     */
//    public boolean hasJokers() {
//        return (deck.length == 54);
//    }
//
//} // end class Deck
//
///**
// * An object of type Hand represents a hand of cards.  The
// * cards belong to the class Card.  A hand is empty when it
// * is created, and any number of cards can be added to it.
// */
//
//class Hand {
//
//    private ArrayList<Card> hand;   // The cards in the hand.
//
//    /**
//     * Create a hand that is initially empty.
//     */
//    public Hand() {
//        hand = new ArrayList<Card>();
//    }
//
//    /**
//     * Remove all cards from the hand, leaving it empty.
//     */
//    public void clear() {
//        hand.clear();
//    }
//
//    /**
//     * Add a card to the hand.  It is added at the end of the current hand.
//     * @param c the non-null card to be added.
//     * @throws NullPointerException if the parameter c is null.
//     */
//    public void addCard(Card c) {
//        if (c == null)
//            throw new NullPointerException("Can't add a null card to a hand.");
//        hand.add(c);
//    }
//
//    /**
//     * Remove a card from the hand, if present.
//     * @param c the card to be removed.  If c is null or if the card is not in
//     * the hand, then nothing is done.
//     */
//    public void removeCard(Card c) {
//        hand.remove(c);
//    }
//
//    /**
//     * Remove the card in a specified position from the hand.
//     * @param position the position of the card that is to be removed, where
//     * positions are numbered starting from zero.
//     * @throws IllegalArgumentException if the position does not exist in
//     * the hand, that is if the position is less than 0 or greater than
//     * or equal to the number of cards in the hand.
//     */
//    public void removeCard(int position) {
//        if (position < 0 || position >= hand.size())
//            throw new IllegalArgumentException("Position does not exist in hand: "
//                    + position);
//        hand.remove(position);
//    }
//
//    /**
//     * Returns the number of cards in the hand.
//     */
//    public int getCardCount() {
//        return hand.size();
//    }
//
//    /**
//     * Gets the card in a specified position in the hand.  (Note that this card
//     * is not removed from the hand!)
//     * @param position the position of the card that is to be returned
//     * @throws IllegalArgumentException if position does not exist in the hand
//     */
//    public Card getCard(int position) {
//        if (position < 0 || position >= hand.size())
//            throw new IllegalArgumentException("Position does not exist in hand: "
//                    + position);
//        return hand.get(position);
//    }
//
//    /**
//     * Sorts the cards in the hand so that cards of the same suit are
//     * grouped together, and within a suit the cards are sorted by value.
//     * Note that aces are considered to have the lowest value, 1.
//     */
//    public void sortBySuit() {
//        ArrayList<Card> newHand = new ArrayList<Card>();
//        while (hand.size() > 0) {
//            int pos = 0;  // Position of minimal card.
//            Card c = hand.get(0);  // Minimal card.
//            for (int i = 1; i < hand.size(); i++) {
//                Card c1 = hand.get(i);
//                if ( c1.getSuit() < c.getSuit() ||
//                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
//                    pos = i;
//                    c = c1;
//                }
//            }
//            hand.remove(pos);
//            newHand.add(c);
//        }
//        hand = newHand;
//    }
//
//    /**
//     * Sorts the cards in the hand so that cards of the same value are
//     * grouped together.  Cards with the same value are sorted by suit.
//     * Note that aces are considered to have the lowest value, 1.
//     */
//    public void sortByValue() {
//        ArrayList<Card> newHand = new ArrayList<Card>();
//        while (hand.size() > 0) {
//            int pos = 0;  // Position of minimal card.
//            Card c = hand.get(0);  // Minimal card.
//            for (int i = 1; i < hand.size(); i++) {
//                Card c1 = hand.get(i);
//                if ( c1.getValue() < c.getValue() ||
//                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
//                    pos = i;
//                    c = c1;
//                }
//            }
//            hand.remove(pos);
//            newHand.add(c);
//        }
//        hand = newHand;
//    }
//
//}
//class BlackjackHand extends Hand {
//
//    /**
//     * Computes and returns the value of this hand in the game
//     * of Blackjack.
//     */
//    public int getBlackjackValue() {
//
//        int val;      // The value computed for the hand.
//        boolean ace;  // This will be set to true if the
//        //   hand contains an ace.
//        int cards;    // Number of cards in the hand.
//
//        val = 0;
//        ace = false;
//        cards = getCardCount();  // (method defined in class Hand.)
//
//        for ( int i = 0;  i < cards;  i++ ) {
//            // Add the value of the i-th card in the hand.
//            Card card;    // The i-th card;
//            int cardVal;  // The blackjack value of the i-th card.
//            card = getCard(i);
//            cardVal = card.getValue();  // The normal value, 1 to 13.
//            if (cardVal > 10) {
//                cardVal = 10;   // For a Jack, Queen, or King.
//            }
//            if (cardVal == 1) {
//                ace = true;     // There is at least one ace.
//            }
//            val = val + cardVal;
//        }
//
//        // Now, val is the value of the hand, counting any ace as 1.
//        // If there is an ace, and if changing its value from 1 to
//        // 11 would leave the score less than or equal to 21,
//        // then do so by adding the extra 10 points to val.
//
//        if ( ace == true  &&  val + 10 <= 21 )
//            val = val + 10;
//
//        return val;
//
//    }  // end getBlackjackValue()
//
//} // end class BlackjackHand