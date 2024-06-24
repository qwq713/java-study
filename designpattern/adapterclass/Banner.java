package designpattern.adapterclass;

/**
 * Banner를 만드는 책임
 * */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public String withParen() {
        return "(" + string + ")";
    }

    public String withAster() {
        return "*" + string + "*";
    }
}
