package 스트림;

import java.util.*;

public class StreamBasic {
    /**
     * 데이터를 조작할때 ( List , Map )
     * 표준화된 방법으로 다룰 수 있음.
     * 주로 Collection F/W를 통해 관리하는 데이터를 처리하기 위해 주로 사용.
     */

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Lee", "Park");

        // 기존
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Stream 활용
        list.stream().forEach(System.out::println);

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Song", 45));
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Park", 21));

        Comparator<Customer> comparator = Comparator.comparingInt(Customer::getAge);


        List<String> result = customers.stream().filter(customer -> customer.getAge() >= 30)
                .sorted(comparator)
                .map(Customer::getName)
                .toList();
        System.out.println("[RESULT]");
        System.out.println(result);
    }
}
