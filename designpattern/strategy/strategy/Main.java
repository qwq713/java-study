package designpattern.strategy.strategy;

import designpattern.strategy.Hand;
import designpattern.strategy.strategy.impl.ProbStrategy;
import designpattern.strategy.strategy.impl.WinningStrategy;

public class Main {

    public static void main(String[] args) {

        Player kim = new Player("Kim", new WinningStrategy(10));
        Player lee = new Player("Lee", new ProbStrategy(20));

        int playCount = 10000;

        for(int i=0;i<playCount;i++){
            Hand kimHand = kim.nextHand();
            Hand leeHand = lee.nextHand();

            if(kimHand.isStronger(leeHand)){
                kim.win();
                lee.lose();
            }else if(leeHand.isStronger(kimHand)){
                kim.lose();
                lee.win();
            }else{
                kim.even();
                lee.even();
            }
        }

        System.out.println("Total result : ");
        System.out.println(kim);
        System.out.println(lee);

    }
}
