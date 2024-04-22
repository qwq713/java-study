package algorithm.leetcode;

import java.util.List;

public class NumberOfIslands {

}

class Solution {
    // todo : 별도의 map을 만들 필요가 없음 -> 어자피 한번만 방문.
    // todo : 우선 호출하고, dfs 로직의 맨 위에서 return 처리해도 됨.
    public void dfs(int y, int x, char[][] grid) {
        if (x < 0
                || y < 0
                || x >= grid[0].length
                || y >= grid.length
                || grid[y][x] == '0') {
            return;
        }

        grid[y][x] = '0';

        dfs(y - 1, x, grid);
        dfs(y, x + 1, grid);
        dfs(y + 1, x, grid);
        dfs(y, x - 1, grid);
    }

    public int numIslands(char[][] grid) {
        int answer = 0;
        int maxY = grid.length;
        int maxX = grid[0].length;

        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (grid[y][x] == '1') {
                    dfs(y, x, grid);
                    answer++;
                }
            }
        }
        return answer;
    }
}
