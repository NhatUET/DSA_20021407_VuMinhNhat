package week12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {
    static int[][] grid;
    static boolean[][] visited;
    static int N, M;
    static int[] xMove = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] yMove = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int connectedCell(int[][] grid) {
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }
        return max;
    }

    private static int count_connected(int i, int j) {
        int count = 0;
        visited[i][j] = true;
        count++;
        for (int k = 0 ; k < 8; k++) {
            int i1 = i + xMove[k];
            int j1 = j + yMove[k];
            if (i1 >= 0 && i1 < N && j1 >= 0 && j1 < M && grid[i1][j1] == 1 && !visited[i1][j1]) {
                count += count_connected(i1, j1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        System.out.print(connectedCell(grid));
    }
}
/*
4 4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
 */