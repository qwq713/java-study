package designpattern.bridge.func;

import designpattern.bridge.impl.DisplayImpl;

import java.util.Random;

public class RandomDisplay extends CountDisplay {
    public RandomDisplay(DisplayImpl displayImpl) {
        super(displayImpl);
    }

    public void randomDisplay(int times) {
        int randomTimes = new Random().nextInt(times);
        System.out.println("Random Times : " + randomTimes);
        multiDisplay(randomTimes);
    }

}
