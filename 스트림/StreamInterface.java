package 스트림;

import java.util.List;
import java.util.Map;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

public class StreamInterface {
    /**
     * Stream API의 최상위 인터페이스는 BaseStream 인터페이스
     * <p>
     * long count() -> 스트림에 포함된 항목의 수를 반환.
     * Stream concat(Stream, Stream) -> 두 개의 스트림을 하나의 스트림으로 반환
     * R collect(Collector) -> 스트림의 항목을 컬렉션 타입의 객체로 반환.
     * Stream filter(Predicate) -> 필터 & 스트림 반환
     * void forEach(Consumer)
     * Optional reduce(BinaryOperator) -> 데이터를 소모하고, 그 결과 반환
     * Object[] toArray()
     * ...
     * <p>
     * -> Stream . Collector . Predicate . Consumer . BinaryOperator ...
     * <p>
     * Stream vs ParallelStream
     */

    public static void main(String[] args) {

        List<String> list = List.of("Lee", "Kim", "Park", "Lee");

        // 스트림 생성 - 컬렉션 객체를 통해 생성
        // 생성 -> Collection 인터페이스는 stream()메소드를 default 메소드로 정의
        Stream<String> stream = list.stream();

        // 사용
        System.out.println(stream.count());

        // 재사용
        try {
            stream.forEach(System.out::println);
        } catch (IllegalStateException exception) {
            System.out.println("스트림은 재사용이 불가합니다.");
        }

        // 스트림 생성 - 스트림 빌더 사용
        /**
         * Stream.Builder -> 스트림을 자체적으로 데이터를 생성하고 처리할 수 있음.
         * Stream.Builder 인터페이스는 Consumer 인터페이스를 상속.
         * 데이터를 추가하는 accept() -> 스트림 빌더에 데이터 추가
         * add() 메소드와 -> 스트림 빌더에 데이터 추가하고 스트림 반환
         * 데이터의 추가 작업을 종료하고, Stream 반환하는 build() 메소드를 정의.
         * */

        Stream.Builder<String> builder = Stream.builder();
        builder.accept("Kim");
        builder.accept("Lee");
        builder.accept("Song");
        builder.accept("Park");

        Stream<String> resultStream = builder.build();
        resultStream.forEach(System.out::println);
    }
}
