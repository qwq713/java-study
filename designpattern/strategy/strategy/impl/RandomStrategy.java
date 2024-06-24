package designpattern.strategy.strategy.impl;

import designpattern.strategy.Hand;
import designpattern.strategy.strategy.Strategy;

import java.util.Random;

public class RandomStrategy implements Strategy {

    private Random random;
    private boolean won;

    private Hand preHand;

    public RandomStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }

    @Override
    public void study(boolean win) {
        this.won = win;
    }
}
