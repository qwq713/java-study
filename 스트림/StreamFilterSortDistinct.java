package 스트림;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterSortDistinct {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Park", 21));
        customers.add(new Customer("Song", 33));
        customers.add(new Customer("Lee", 33));
        customers.add(new Customer("Kim", 33)); // 중복 데이터

        // filter : 중간연산 -> Stream 객체
        System.out.println("Filter");
        Stream<Customer> stream = customers.stream();
        stream.filter(customer -> customer.getAge() > 30)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Distinct");
        // distinct : 병렬 스트림의 경우 성능에 대한 고려 필요. 중복 객체 비교는 equals 메소드를 이용함.
        stream = customers.stream();
        stream.filter(customer -> customer.getAge() > 30)
                .distinct().forEach(System.out::println);

        System.out.println();
        System.out.println("Sorted");
        customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .forEach(System.out::println);

        // 스트림의 매핑(map) 연산은 스트림이 관리하는 데이터를 다른 형태의 데이터로 변환할 수 있다.
        // map. mapToInt. mapToDouble. mapToLong 등이 존재
        // map() 메소드는 Function 함수형 인터페이스
        stream = customers.stream();
        List<String> nameList = stream.map(Customer::getName).collect(Collectors.toList());
        System.out.println(nameList);
        
        // 최종 연산
        // forEach() . collect()
        // 이외에도. 아래와 같은 최종 연산이 존재
        // allMatch : 스트림 데이터가 모두 일치하는지 확인
        // anyMatch : 스트림 데이터 하나라도 일치하는지 확인
        // noneMatch : 하나도 알치하지 않는지 확인
        // findFirst : 데이터 중 가장 첫번째 데이터를 반환.
        // reduce : 임의의 데이터를 반환
        stream = customers.stream();
        boolean kim = stream.anyMatch(elt -> elt.getName().equals("Kim"));

        stream = customers.stream();
    }
}
