package algorithm.programmers;


/**
 * 접근한 방법은 맞음.
 * 초기 조건에 따라 배열을 나눌 필요성이 있음을 알자.
 * <p>
 * dp[2][n]
 * => dp[0][i] : 첫 스티커를 땐 경우
 * => dp[1][1] : 첫 스티커를 떼지 않은 경우.
 */
public class 스티커모으기_미해결 {
    public int solution(int sticker[]) {
        int n = sticker.length;
        int[][] dp = new int[2][n];
        dp[0][0] = sticker[0];
        dp[0][1] = dp[0][0];
        for (int i = 2; i < n; i++) {
            int a = dp[0][i - 2] + sticker[i];
            int b = dp[0][i - 1] + sticker[i+1];
        }


        dp[1][0] = 0;

        int len = sticker.length;
        int[][] sum = new int[len][3];

        sum[0][0] = sticker[0]; // 뗏을때
        sum[0][1] = 0; // 안뗏을때
        sum[0][2] = Math.max(sum[0][0], sum[0][1]);

        for (int i = 1; i < len - 1; i++) {
            // 전꺼 안떼고 , 이번에 뗏을때
            sum[i][0] = sum[i - 1][1] + sticker[i];

            // 잔까 떼고 , 이번거 안뗏을때
            sum[i][1] = sum[i - 1][0];

            sum[i][2] = Math.max(sum[i][0], sum[i][1]);
        }

        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
