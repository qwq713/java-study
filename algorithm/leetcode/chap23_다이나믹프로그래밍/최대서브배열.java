package algorithm.leetcode.chap23_다이나믹프로그래밍;

import java.util.*;

public class 최대서브배열 {

    //     [ -2, 1 ,-3 ,4 ,-1 ,2 ,1 ,6 , 4 ] -> 4
    public int maxSubArray(int[] nums) {
        /**
         * sumArray[i] := i번째까지의 최대 부분합
         * */
        List<Integer> sumArray = new ArrayList<>(List.of(nums[0]));

        for (int i = 1; i < nums.length; i++) {
            /**
             * i-1 번째까지의 부분합이 0보다 작은 경우
             * -> 최대합을 구할 때 도움이 되지 않으므로 최대 값에 현재 값을 넣는다.
             * i-1 번째까지의 부분합이 0보다 큰 경우
             * -> 현재값을 더하여 ( nums[i] ) i번째까지의 최대 합을 갱신한다.
             *
             * 만약 i 번째값이 음수일 경우 0~i 번째까지의 합은 고려할 필요가 없는가 ?
             * -> NO 다음의 케이스를 고려하자
             * [ 1,2,3,-1,5 ] : 1-5번째까지의 최대합은 1+2+3-1+5 이므로. 1-3번째까지의 부분합보다 크다.
             * */
            if (sumArray.get(i - 1) < 0) {
                sumArray.add(nums[i]);
            } else {
                sumArray.add(sumArray.get(i - 1) + nums[i]);
            }
        }
        return Collections.max(sumArray);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -6, 4};
        int result = new 최대서브배열().maxSubArray(nums);
        System.out.println(result);

    }
}
