package org.nhnacademy.lsj;

import java.util.Scanner;
import org.nhnacademy.lsj.blackJack.BlackJackHand;
import org.nhnacademy.lsj.blackJack.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Problem4 {

    private static final Logger logger = LoggerFactory.getLogger(Problem4.class);

    public static void problem4() {

        BlackJackHand blackJackHand = new BlackJackHand();


        Scanner sc = new Scanner(System.in);

        String isMoreGame;

        do {

            blackJackHand.handClear();
            logger.info("게임을 진행할 카드 개수를 입력해 주세요 2-6 사이에 입력");
            int num = sc.nextInt();
            sc.nextLine();

            if (num < 2 || num > 6) {
                logger.error("2-6사이의 입력만 가능합니다.");
                throw new IllegalArgumentException();
            }


            Deck deck = new Deck(false); // 조커 포함안해
            deck.shuffle(); // 섞어


            for (int i = 0; i < num; i++) {
                blackJackHand.add(deck.dealCard()); // 핸드에 추가
            }

            logger.info("총 숫자는 : {}", blackJackHand.getBlackjackValue());

            logger.info("게임을 더 하시겠습니까? Press Y  | Press N ");

            isMoreGame = sc.nextLine();

            if (!isMoreGame.equals("Y") && !isMoreGame.equals("N")) {
                throw new IllegalArgumentException("입력은 Y | N 만 가능합니다.");
            }

        } while (isMoreGame.equals("Y"));


    }

}
