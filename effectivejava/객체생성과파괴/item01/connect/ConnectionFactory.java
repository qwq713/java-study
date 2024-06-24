package effectivejava.객체생성과파괴.item01.connect;

public class ConnectionFactory {
    public static Connection getConnection(DbType dbType) {
        if (dbType.equals(DbType.MySQL)) {
            return new MySQLConnection();
        } else if (dbType.equals(DbType.PostGreSQL)) {
            return new PostgreSQLConnection();
        } else {
            throw new IllegalArgumentException("No valid database Type");
        }
    }
}
