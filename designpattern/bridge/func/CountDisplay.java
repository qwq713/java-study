package designpattern.bridge.func;

import designpattern.bridge.impl.DisplayImpl;

import java.util.stream.IntStream;

/* 확장된 기능 */
public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        IntStream.range(0, times).forEach(elt -> display());
        close();
    }
}
