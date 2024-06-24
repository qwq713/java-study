package designpattern.bridge;

import designpattern.bridge.func.Display;
import designpattern.bridge.impl.FileDisplayImpl;

/**
 * Bridge Pattern : 기능 계층과 구현 계층을 나눈다.
 */
public class Main {

    public static void main(String[] args) {
//        Display display = new Display(new StringDisplayImpl("Hello korea"));
//        CountDisplay countDisplay = new CountDisplay(new StringDisplayImpl("Hello universe"));
//
//        display.display();
//
//        countDisplay.display();
//
//        countDisplay.multiDisplay(5);
//
//        RandomDisplay randomDisplay = new RandomDisplay(new StringDisplayImpl("Random text"));
//        randomDisplay.randomDisplay(10);

        Display display = new Display(new FileDisplayImpl("/Users/jihwan/algorithm/java-interview/algorithm/sample.txt"));
        display.display();
    }
}
