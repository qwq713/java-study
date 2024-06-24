package algorithm.시간초과;

import java.util.Arrays;

/**
 * check 배열을 생성하고 현재 도달하는 위치에 check한다.
 * i=0 부터 전파가 도달하는지 검사한다.
 * 만약 i에 전파가 닿지 않는다면 . i + w(전파범위) 에 기지국을 설치하고 i-w ~ i+w에 전파가 도달함을 check배열에 표시한다.
 *
 * n 이 최대 2억이므로. n을 기준으로 풀면 시간 초과가 발생한다.
 *
 * station을 하나씩 검사
 * 전파가 도달하지 않는 좌측. 검사 -> 설치
 * 어자피 우측은 현재 station이 가장 범위가 넓음
 * 그다음 station에서 전파가 닿지 않는 좌측 검사 -> 설치
 * 마지막은 닿지않는 우측 검사 -> 설치
 */
public class 기지국설치_시간초과 {

    private void checkArray(boolean[] check, int start, int end, int n) {
        start = Math.max(start, 0);
        end = Math.min(end, n - 1);
        Arrays.fill(check, start, end + 1, true);
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int station : stations) {
            int start = station - w - 1;
            int end = station + w - 1;
            checkArray(check, start, end, n);
        }
        int i = 0;
        while (i < n) {
            if (!check[i]) {
                answer++;
                checkArray(check, i, i + 2 * w, n);
                i += 2 * w;
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int solution = new 기지국설치_시간초과().solution(11, new int[]{4, 11}, 1);
        System.out.println(solution);

        int solution1 = new 기지국설치_시간초과().solution(1, new int[]{1}, 1);
        System.out.println(solution1);

    }
}
