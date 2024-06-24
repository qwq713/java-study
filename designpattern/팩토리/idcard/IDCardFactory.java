package designpattern.팩토리.idcard;

import designpattern.팩토리.framework.Factory;
import designpattern.팩토리.framework.Product;

public class IDCardFactory extends Factory {

    private int serial = 100;

    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");

    }
}
