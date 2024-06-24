package designpattern.template;

import java.util.stream.IntStream;

/**
 * Template Method 패턴 -> 로직 공통화.
 *
 * 메서드 로직을 Template ( AbstractDisplay ) 에 정의
 * -> display()
 *
 * 그리고 display에 사용되는 메서드는 추상 메서드로 정의해서 extends 후 하위 클래스에서 구현.
 * */

public abstract class AbstractDisplay {
    public abstract void open();

    public abstract void print();

    public abstract void close();

    public void display() {
        open();
        IntStream.range(0, 5).forEach(e -> print());
        close();
    }

}
