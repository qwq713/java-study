package designpattern.프로토타입;

import designpattern.프로토타입.framework.Product;

import java.util.stream.IntStream;

public class MessageBox implements Product {

    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;
        IntStream.range(0, decolen).forEach(elt -> System.out.print(decochar));
        System.out.println();
        System.out.println(decochar + s + decochar);
        IntStream.range(0, decolen).forEach(elt -> System.out.print(decochar));
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
