package algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        List<Integer> listA = new ArrayList<>(Arrays.stream(A).boxed().toList()).stream().sorted((o1, o2) -> o2-o1).toList();
        List<Integer> listB = new ArrayList<>(Arrays.stream(B).boxed().toList()).stream().sorted((o1, o2) -> o2-o1).toList();

        int answer = 0;

        int a = 0;
        int b = 0;
        int len = A.length;
        while (a < len && b < len) {
            int aNum = listA.get(a);
            int bNum = listB.get(b);

            if (aNum < bNum) {
                a++;
                b++;
                answer++;
            } else {
                a++;
            }
        }
        return answer;
    }
    /**
     *
     *
     * 1 1 1 1
     *
     * 1. 정석
     * 2. binarySearch
     *
     * */
}
