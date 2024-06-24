package effectivejava.객체생성과파괴.item01.connect;

public class MySQLConnection implements Connection{
    @Override
    public void connect() {
        System.out.println("MySQL connect()");
    }
}
