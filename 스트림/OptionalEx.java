package 스트림;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalEx {
    /**
     * 개선포인트 1. findFirst 혹은 findAny 사용할때는 Optional Type 을 return.
     * */
    public static void main(String[] args) {
//        List<String> strList = new ArrayList<>(List.of(new String[]{"a", "b", "c"}));

        List<String> strList = new ArrayList<>(List.of("a", "b", "c"));
        Optional<String> first = strList.stream().filter("a"::equals).findFirst();

        if (first.isPresent()) {
            System.out.println("present");
        } else {
            System.out.println("empty");
        }
    }
}
