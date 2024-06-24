package designpattern.프로토타입;

import designpattern.프로토타입.framework.Manager;
import designpattern.프로토타입.framework.Product;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderLine underLine = new UnderLine('-');
        MessageBox messageBox = new MessageBox('*');

        manager.register("strong message", underLine);
        manager.register("warning box", messageBox);

        Product p1 = manager.create("strong message");
        Product p2 = manager.create("warning box");

        p1.use("hello world");
        p2.use("hello world");
    }
}
