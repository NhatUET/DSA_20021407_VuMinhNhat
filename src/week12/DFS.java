package week12;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DFS {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>(1001);
    static boolean[] visited = new boolean[1001];
    public static void input() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        Arrays.fill(visited, false);
    }
    public static void dfs(int u) {
        System.out.print(u);
        visited[u] = true;
        for (int x : adj.get(u)) {
            if (!visited[x]) {
                dfs(x);
            }
        }
    }
    public static void main(String[] args) {
        input();
        dfs(1);
    }
}
