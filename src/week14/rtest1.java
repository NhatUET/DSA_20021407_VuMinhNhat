package week14;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class rtest1 {
    static void dfs(ArrayList<ArrayList<Integer>> a, boolean[] visited, int n) {
       // System.out.print(n + " ");
        if (!visited[n]) {
            visited[n] = true;
            for (int x : a.get(n)) {
                if (!visited[x]) {
                    dfs(a,visited,x);
                }
            }
        }
    }

    static void bfs(ArrayList<ArrayList<Integer>> a, boolean[] visited, int n) {
        LinkedList<Integer> q = new LinkedList<>();
        visited[n] = true;
        q.add(n);
        while (!q.isEmpty()) {
            n = q.remove();
            System.out.print(n + " ");
            for (int x : a.get(n)) {
               if (!visited[x]) {
                   visited[x] = true;
                   q.add(x);
               }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] visited = new boolean[n+1];
        boolean[] visited1 = new boolean[n+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            adj.get(x1).add(x2);
            adj.get(x2).add(x1);
        }
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                c++;
                dfs(adj,visited, i);
            }
        }
        System.out.print(c);
    }
}
