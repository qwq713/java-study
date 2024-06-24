package designpattern.adapterclass;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String string = "hello";
        Print print = new PrintBanner(string);
        print.printWeek();
        print.printStrong();

    }
}
