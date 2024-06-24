package algorithm.programmers.lv2;

import java.util.*;
/**
 * 크기의 종류가 가장 적은 K개의 귤을 선택하기 위해서 다음의 로직을 통해 문제를 해결.
 * 크기별 개수를 List<Pair> 로 구현한다.
 * 개수를 기반으로 오름차순한다.
 * 가장 적은 Pair를 전체 개수가 K개가 되도록 반복하여 제거한다.
 * */
public class 귤고르기 {

    class Pair {
        int size;
        int count;

        Pair(int size, int count) {
            this.size = size;
            this.count = count;

        }
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(tangerine).forEach(t -> {
            if (!map.containsKey(t)) {
                map.put(t, 0);
            }
            map.put(t, map.get(t) + 1);
        });

        List<Pair> pairList = new ArrayList<>();

        map.keySet().forEach(key -> {
            pairList.add(new Pair(key, map.get(key)));
        });

        pairList.sort(Comparator.comparingInt(p -> p.count));

        int removeCount = tangerine.length - k;

        while(removeCount-- > 0){
            int now = pairList.get(0).count;
            if(now > 0){
                pairList.get(0).count = now - 1;
            }

            if(pairList.get(0).count == 0){
                pairList.remove(0);
            }
        }

        return pairList.size();
    }

    public static void main(String[] args) {
        int solution = new 귤고르기().solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        System.out.println(solution);
    }
}
