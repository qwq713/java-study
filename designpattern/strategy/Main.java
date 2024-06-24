package designpattern.strategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        // 사전순으로 큰 순서
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
