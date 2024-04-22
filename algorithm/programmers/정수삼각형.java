package algorithm.programmers;

public class 정수삼각형 {
    // [
    // [7],
    // [3, 8],
    // [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int[][] sum = new int[height][height];

        sum[0][0] = triangle[0][0];

        for (int h = 1; h < height; h++) {
            for (int c = 0; c < triangle[h].length; c++) {
                if (c == 0) {
                    sum[h][c] = sum[h - 1][c] + triangle[h][c];
                } else if (h == c) {
                    sum[h][c] = sum[h - 1][c - 1] + triangle[h][c];
                } else {
                    sum[h][c] = Math.max(sum[h - 1][c - 1], sum[h - 1][c]) + triangle[h][c];
                }
            }
        }
        for (int c = 0; c < height; c++) {
            answer = Math.max(sum[height - 1][c], answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        int answer = new 정수삼각형().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        System.out.println(answer);
    }
}
