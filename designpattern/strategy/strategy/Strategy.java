package designpattern.strategy.strategy;

import designpattern.strategy.Hand;

public interface Strategy {

    /* 다음에 낼 손을 얻기 위한 메소드 */
    Hand nextHand();

    /* 직전에 낸 손으로 이겼는지 졌는지 학습하는 메소드 */
    void study(boolean win);
}
