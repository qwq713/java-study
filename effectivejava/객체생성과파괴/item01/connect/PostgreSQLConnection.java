package effectivejava.객체생성과파괴.item01.connect;

public class PostgreSQLConnection implements Connection{
    @Override
    public void connect() {
        System.out.println("PostgreSQL connect()");
    }
}
