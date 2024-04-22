package algorithm.leetcode.chap07_배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> answer = List.of(nums[i], nums[left], nums[right]);
                    // List<PrimitiveType> 에 대한 contains 제공
                    if(!result.contains(answer)){
                        result.add(List.of(nums[i], nums[left], nums[right]));
                    }
                    left++; // point. 이부분이 없으면 무한 Loop.
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // -5 -1 -1 0 1 2
        // -5 -1 2 = -4
        // -5 -1 2 = -4
        // -5 0 2 = -3
        // -5 1 2 = -2

        // -1 -1 2 = 0

        List<List<Integer>> result = new Sum3().threeSum(new int[]{-1, 0, 1, 2, -1, -5});
        System.out.println(result);
    }
}
