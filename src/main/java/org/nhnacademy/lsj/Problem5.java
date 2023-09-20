package org.nhnacademy.lsj;

import java.util.Scanner;
import org.nhnacademy.lsj.blackJack.BlackJackHand;
import org.nhnacademy.lsj.blackJack.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 블랙잭 게임이 진행됨.
 */
public class Problem5 {

    private static final Logger logger = LoggerFactory.getLogger(Problem5.class);

    /**
     * 유저는 100달러를 가짐 , 돈이 떨어질떄까지 블랙잭 게임 진행.
     */
    public static void problem5() {

        Scanner sc = new Scanner(System.in);

        BlackJackHand user = new BlackJackHand();
        BlackJackHand dealer = new BlackJackHand();
        int betMoney;


        do { // 돈 다 떨어질 떄 까지 구현

            user.clear();
            dealer.clear();
            logger.info("사용자의 현제 돈 {}", user.getMoney());


            logger.info("게임에 배팅할 돈을 입력하세요");
            betMoney = sc.nextInt();

            boolean flag = playGame(user, dealer);
            bettingResult(user, dealer, flag, betMoney);
        } while (user.isEnoughMoney());

        logger.info("사용자의 돈이 다 떨어졌습니다.\n카지노에서 나가세요");

    }

    /**
     * 게임의 결과를 나타냄 .
     *
     * @param user     사용자.
     * @param dealer   컴퓨터.
     * @param flag     승패유무.
     * @param betMoney 사용자가 배팅한 돈.
     */
    public static void bettingResult(BlackJackHand user, BlackJackHand dealer, boolean flag, int betMoney) {

        if (flag) {
            logger.info("사용자가 이겼습니다 !  사용자 카드 총 합 {} 딜러 카드 총 합{}",
                    user.getBlackjackValue(), dealer.getBlackjackValue());
            user.addMoney(betMoney);
            return;
        }
        logger.info("딜러가 이겼습니다 !  사용자 카드 총 합 {} 딜러 카드 총 합{}",
                user.getBlackjackValue(), dealer.getBlackjackValue());
        user.minusMoney(betMoney);


    }

    /**
     * 블랙잭 게임이 진행됨 . 2장씩 받은 후 플레이어가 카드를 받을지 선택함 .
     * 컴퓨터는 블랙잭 기본 룰을 따름.
     *
     * @param user   사용자 .
     * @param dealer 컴퓨터.
     * @return 게임의 승패.
     */
    public static boolean playGame(BlackJackHand user, BlackJackHand dealer) {

        Scanner sc = new Scanner(System.in);

        Deck userDeck = new Deck();
        Deck dealerDeck = new Deck();


        initHand(dealer, dealerDeck);
        initHand(user, userDeck); // 2장씩 뽑기


        // 승자 판별
        if (user.getBlackjackValue() == 21) {
            return true;
        } else if (dealer.getBlackjackValue() == 21) {
            return false;
        }

        user.printHand(); // 카드보고

        logger.info("사용자가 확인할 딜러의 카드 를 골라주세요 1번 or 2번");
        int cardIndex = sc.nextInt();
        sc.nextLine(); // 버퍼제거

        if (cardIndex > 2 || cardIndex < 1) {
            throw new IllegalArgumentException("확인할 카드는 1번 혹은 2번만 가능합니다.");
        }

        dealer.printHandByIndex(cardIndex);

        while (true) {
            if (user.getBlackjackValue() > 21) {
                logger.info("사용자의 패배");
                return false;
            }

            logger.info("Hit , Stand 중 하나를 입력해 주세요");
            String answer = sc.nextLine();

            if (!answer.equals("Hit") && !answer.equals("Stand")) {
                throw new IllegalArgumentException("입력이 올바르지 않습니다.");
            }

            if (answer.equals("Hit")) {
                user.add(userDeck.dealCard());
                continue;
            }

            break;
        }

        dealerDealCard(dealer, dealerDeck);

        // 딜러가 21넘기거나 , 딜러의 총합이 사용자의 총액보다 작으면 사용자의 승리
        if (dealer.getBlackjackValue() > 21 || dealer.getBlackjackValue() < user.getBlackjackValue()) {
            return true;
        }
        return false;


    }

    /**
     * 딜러는 총 합이16 이하라면 계속해서 카드를 받는다.
     *
     * @param dealer 컴퓨터.
     * @param deck   컴퓨터의 카드 덱.
     */
    public static void dealerDealCard(BlackJackHand dealer, Deck deck) {

        if (dealer.getBlackjackValue() <= 16) {
            dealer.add(deck.dealCard());
            dealerDealCard(dealer, deck);
        }

    }

    /**
     * 손패를 초기화함 , 블랙잭은 2장을 받고 시작하는 것이 기본 .
     *
     * @param hand 카드를 쥘 핸드.
     * @param deck 카드를 뽑을 덱 .
     */
    public static void initHand(BlackJackHand hand, Deck deck) {
        deck.shuffle();
        hand.add(deck.dealCard());
        hand.add(deck.dealCard());

    }


}
