package designpattern.프로토타입;

import designpattern.프로토타입.framework.Product;

import java.util.stream.IntStream;

public class UnderLine implements Product {

    private char ulchar;

    public UnderLine(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;
        IntStream.range(0, decolen).forEach(elt -> System.out.print(ulchar));
        System.out.println();
        System.out.println(ulchar + s + ulchar);
        IntStream.range(0, decolen).forEach(elt -> System.out.print(ulchar));
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product product = null;
        try {
            product = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
