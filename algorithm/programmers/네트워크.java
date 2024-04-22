package algorithm.programmers;

public class 네트워크 {

    public void dfs(int start, int[] visit, int[][] computers, int n) {
        visit[start] = 1;
        for (int next = 0; next < n; next++) {
            if (visit[next] == 0 && computers[start][next] == 1) {
                dfs(next, visit, computers, n);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        int[] visit = new int[n];

        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                answer += 1;
                dfs(i, visit, computers, n);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int result = new 네트워크().solution(n,computers);
        System.out.println(result);
    }
}
