package algorithm.programmers;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
 * <p>
 * 야근 지수를 최소화하기위해서는 현 시점에서 최대 작업량이 남은 업무에 업무시간을 투자해야한다.
 */
public class 야근지수 {
    public long solution(int n, int[] works) {

        PriorityQueue<Integer> maxHq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        Arrays.stream(works).forEach(maxHq::add);

        for (int i = 0; i < n; i++) {
            if (maxHq.isEmpty()) {
                return 0;
            }

            int hardWork = maxHq.poll();
            if (hardWork - 1 > 0) {
                maxHq.add(hardWork - 1);
            }
        }
        return maxHq.stream().mapToLong(elt -> (long) elt * elt).sum();
    }

    public static void main(String[] args) {
        System.out.println(new 야근지수().solution(4, new int[]{4, 3, 3}));
        System.out.println(new 야근지수().solution(1, new int[]{2, 1, 2}));
        System.out.println(new 야근지수().solution(3, new int[]{1, 1}));
    }
}
