package designpattern.bridge.func;

import designpattern.bridge.impl.DisplayImpl;

/* 기능 */
public class Display {

    /* 상속이 아닌 '위임' 사용. */
    /* 구체적인 Action을 사용하는 객체를 다른 클래스로 넘김 */
    private final DisplayImpl displayImpl;

    public Display(DisplayImpl displayImpl) {
        this.displayImpl = displayImpl;
    }

    public void open() {
        displayImpl.rawOpen();
    }

    public void print() {
        displayImpl.rawPrint();
    }

    public void close() {
        displayImpl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
