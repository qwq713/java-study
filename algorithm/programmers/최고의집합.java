package algorithm.programmers;

import java.util.Arrays;

public class 최고의집합 {
    // 곱하는 수들이 가장 비슷할때 최대가 됨.
    public int[] solution(int n, int s) {

        if (n > s) {
            return new int[]{-1};
        }
        int mulValue = s / n;
        int res = s - mulValue * n;

        int[] answer = new int[n];
        Arrays.fill(answer, mulValue);

        for (int i = 0; i < res; i++) {
            answer[n - 1 - i]++;
        }

        return answer;
    }
}
