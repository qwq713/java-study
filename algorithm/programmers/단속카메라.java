package algorithm.programmers;

import java.util.Arrays;
/**
 * 최소한의 카메라로 모든 차량을 단속하기 위해서 다음의 로직을 사용했다.
 *
 * 1. 나가기 전에 무조건 감시 카메라가 한대가 존재해야한다.
 * 2. 만약 진입/진출 시점이 겹치는 구간이 있다면, 가장 늦게 진입한 차를 기준으로 감시 카메라를 설치한다.
 *
 * 따라서 위 로직을 구현하기 위해 아래와 같이 정렬한다.
 *
 * routes를 나간시점 오름차순으로 정렬한다.
 * 만약 나간시점이 같을 경우 진입시점의 역순으로 정렬한다.
 *
 * 이후 감시카메라를 최소 진입구간보다 이전인 -30001로 초기화 이후. 위 원칙에 따라 감시카메라를 설치한다.
 *
 * */
public class 단속카메라 {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (r1, r2) -> {
            if (r1[1] == r2[1]) {
                return r2[0] - r1[0];
            }
            return r1[1] - r2[1];
        });

        int answer = 0;
        int camera = -30001;

        for (int[] route : routes) {
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] array = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int result = new 단속카메라().solution(array);
        System.out.println(result);
    }
}
