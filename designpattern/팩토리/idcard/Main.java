package designpattern.팩토리.idcard;

import designpattern.팩토리.framework.Factory;
import designpattern.팩토리.framework.Product;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product idCard = factory.create("jihwan");
        Product idCard2 = factory.create("jihwan02");
        idCard.use();
        idCard2.use();
    }
}
