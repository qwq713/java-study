package algorithm.programmers;

/**
 *
 * 당연한거.
 * 1. 좌측에 있는 기지국은 우측에 존재하는 기지국보다 전파를 보낼 수 있는 위치가 작다. (전체 좌표 기준 왼쪽)
 * 2. 전파가 필요한 아파트가 10개가 연속으로 이어질때, 기지국의 전파범위가 1 이면 다음의 방법으로 전파기가 필요한 개수를 계산한다.
 * 3. +(10 / 3) 만약 3으로 정확하게 나눠지지 않는 경우 1을 더한다. => +4
 *
 * 문제에서 index를 정할때는 한글로 명확한 의미를 부여한다.
 *
 * */
public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int leftStart = 1; // 현재 기지국이 닿는 않는 아파트 번호
        for (int station : stations) {
            int leftEnd = station - w; // 현재 기지국이 닿는 아파트 번호 좌측 끝 : 3
            if (leftStart < leftEnd) {
                int requireCover = (leftEnd - leftStart); // 좌측에 기지국이 필요한 좌측 아파트 수
                answer += requireCover / (w * 2 + 1); // 기지국 설치 필요한 개수. (소수점 버림 )
                if (requireCover % (w * 2 + 1) != 0) { // 소수점이 버려졌으면 기지국이 1개 더 필요함.
                    answer++;
                }
            }
            leftStart = station + w + 1; // 현재 기지국이 닿지 않는 아파트 번호 -> 기지국 + 범위 + 1
        }
        // 기지국 범위가 다 닿으려면 leftstart가 n+1 보다 크거나 같아야함.
        if(leftStart < n+1 ){
            // leftStart ~ n 까지 커버해야함.
            int requireCover = n - leftStart + 1;
            answer += requireCover / (w * 2 + 1); // 기지국 설치 필요한 개수. (소수점 버림 )
            if (requireCover % (w * 2 + 1) != 0) { // 소수점이 버려졌으면 기지국이 1개 더 필요함.
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        int solution = new 기지국설치().solution(11, new int[]{4, 11}, 1);
//        System.out.println(solution);

        int solution1 = new 기지국설치().solution(1, new int[]{1}, 1);
        System.out.println(solution1);

//        int solution2 = new 기지국설치().solution(16, new int[]{9}, 2);
//        System.out.println(solution2);

    }
}
