package algorithm.leetcode.chap07_배열;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] solution(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] bestSolution(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numMap.containsKey(target - num) && i != numMap.get(target - num)) {
                return new int[]{i, numMap.get(target - num)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = new TwoSum().solution(new int[]{2, 6, 11, 15}, 8);
        int[] result02 = new TwoSum().bestSolution(new int[]{2, 6, 11, 15}, 8);
        System.out.println(result[0] + " , " + result[1]);
        System.out.println(result02[0] + " , " + result02[1]);
    }
}
