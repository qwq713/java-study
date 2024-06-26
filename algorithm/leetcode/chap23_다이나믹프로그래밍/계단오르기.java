package algorithm.leetcode.chap23_다이나믹프로그래밍;

public class 계단오르기 {

    /**
     * 1계단 혹은 2개씩 계단을 오를 수 있다.
     * 정상에 오르기 위해서는 몇가지 경로가 있는지 계산해라.
     */
    public int climbStairs(int n) {
        int[] stairs = new int[n + 1];

        // 0계단에 오르는 방법 : 1개
        // 1계단에 오르는 방법 : 0계단에서 1칸 올라간다 -> 0계단
        stairs[0] = 1;
        stairs[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            stairs[i] = stairs[i - 2] + stairs[i - 1];
        }
        return stairs[n];
    }

    int[] dp = new int[46];

    public int climbStairsDp(int n) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climbStairsDp(n - 1) + climbStairs(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        int ret = new 계단오르기().climbStairs(10);
        System.out.println(ret);
    }
}
