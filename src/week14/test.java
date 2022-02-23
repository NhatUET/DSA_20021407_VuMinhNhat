package week14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj;
    static int n;
    static int m;

    static void DFS(int i) {
        if (!visited[i]) {
            visited[i] = true;
            for (int x : adj.get(i)) {
                DFS(x);
            }
        }
    }

    static void BFS() {
        Queue<Integer> q = new LinkedList<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1];
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            adj.get(x1).add(x2);
            adj.get(x2).add(x1);
        }

        DFS(1);
    }

}
