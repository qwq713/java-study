package algorithm.leetcode.chap07_배열;

import java.util.ArrayDeque;
import java.util.Deque;

public class Re_TrappingRainWater {
    public int solution(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            // 변곡점을 만나는 경우
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {

                int top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                // 스택의 마지막 위치까지를 거리로 계산
                int distance = i - stack.peek() - 1;

                // 현재 높이 or 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.peek()] - height[top]);

                // 물이 쌓이는 양
                volume += distance * waters;
            }
            stack.push(i);
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 0, 1, 2};
        int answer = new Re_TrappingRainWater().solution(input);
        System.out.println(answer);
    }
}
