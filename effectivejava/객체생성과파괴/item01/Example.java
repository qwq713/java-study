package effectivejava.객체생성과파괴.item01;

import effectivejava.객체생성과파괴.item01.connect.Connection;
import effectivejava.객체생성과파괴.item01.connect.ConnectionFactory;
import effectivejava.객체생성과파괴.item01.connect.DbType;

public class Example {

    /**
     * ITEM 01. 생성자 대신 정적 팩터리 메서드를 고려하라.
     * */
    public static void main(String[] args) {

        // 1. 정적 팩토리 메서드 시그니처가 고정된 생성자와는 달리 명확한 의미를 한 클래스내에서 여러개 담을 수 있다.
        // Boolean.valueOf는 boolean 을 Boolean ( Wrapper )로 변환한다.
        Boolean result = Boolean.valueOf(true);

        // 2. 정적 팩토리 메서드를 잘 정의하면 호출 때마다 메서드를 새롭게 생성하지 않아도 된다.
        Boolean false01 = Boolean.valueOf(false);
        Boolean false02 = Boolean.valueOf(false);

        // IDE에서는 결과값이 false 라고 유추하지만. 실제 결과는 true 이다.
        System.out.println(false01 == false02);
        // 그 이유는 Boolean의 valueOf 구현체를 보면 알 수 있다.
        // valueOf는 boolean에 따라 미리 준비한 1개의 static final Boolean 객체를 리턴하고있다.

        // 이는 정적 팩토리 메서드를 잘 설계할 경우. 생성자와 다르게 불필요한 메모리 사용을 절감할 수 있음을 알 수 있다.

        // 3. 반환 타입의 하위 객체를 반환할 수 있다.
        // 4. 입력 매개변수에 따라, 하위 타입이기만 하면 매번 다른 클래스의 객체를 반환할 수 있다.
        // 예를들어 DB연동과 관련된 Connect라는 인터페이스에 connect()라는 메서드가 실질적으로 DB를 연동한다고 가정하고,
        // Connection과 같은 인터페이스 및 ConnectionFactory를 작성할 수 있다.
        Connection mySQLConnection = ConnectionFactory.getConnection(DbType.MySQL);
        Connection postgreSQLConnection = ConnectionFactory.getConnection(DbType.PostGreSQL);

        mySQLConnection.connect();
        postgreSQLConnection.connect();

        // 5. 정적 팩토리 작성 시점에는 반환 객체의 클래스가 존재하지 않아도 된다.
    }
}
