package designpattern.adapterclass;

/**
 * Print 하는 책임.
 * */
public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeek() {
        System.out.println(withParen());
    }

    @Override
    public void printStrong() {
        System.out.println(withAster());
    }
}
