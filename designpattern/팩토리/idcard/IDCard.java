package designpattern.팩토리.idcard;

import designpattern.팩토리.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;

    IDCard(String owner, int serial) {

        System.out.println(owner + "의 카드를 만듭니다. 식별번호는 " + serial + "입니다.");
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[IDCard:" + owner + ']';
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
