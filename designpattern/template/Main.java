package designpattern.template;

/**
 * 기능을 추가하려면 ?
 * -> Display를 상속받는 func 클래스 정의

 * 구현을 추가하려면 ?
 * -> DisplayImpl을 상속받는 impl 클래스 정의
 * */
public class Main {
    public static void main(String[] args) {
        AbstractDisplay abstractDisplay = new StringDisplay("Hello World");
        abstractDisplay.display();
    }
}
