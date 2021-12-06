package week13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Graph {
    static class Edge {
        int v1;
        int v2;

        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public Edge(int v1) {
            this.v1 = v1;
        }
    }

    // xay dựng đồ thị qua danh sách cạnh
    static int V; // so dinh
    static int E; // so canh
    static ArrayList<Edge> graph = new ArrayList<>(E + 1);
    public Graph(int v, int e) {
        V = v;
        E = e;
        graph = new ArrayList<>(e+1);
    }
    static void addEdge(int v1, int v2) {
        Edge e = new Edge(v1, v2);
        graph.add(e);
    }

    static void removeEdge(int v1, int v2) {
        for (Edge e : graph) {
            if (e.v1 == v1 && e.v2 == v2) graph.remove(e);
            else if (e.v1 == v2 && e.v2 == v1) graph.remove(e);
        }
    }

    static void addVer(int v) {
        Edge e = new Edge(v);
        graph.add(e);
    }

    static void removeVer(int v) {
        graph.removeIf(e -> e.v1 == v || e.v2 == v);
    }

    static boolean hasConnect(int v1, int v2) {
        for (Edge e : graph) {
            if (e.v1 == v1 && e.v2 == v2 || e.v1 == v2 && e.v2 == v1) return true;
        }
        return false;
    }

    static int[] getAdjVer(int v) {
        //int[] adjV = new int[E+1];
        HashSet<Integer> adjV = new HashSet<>();
        for (Edge e : graph) {
            if (e.v1 == v) adjV.add(e.v2);
            else if (e.v2 == v) adjV.add(e.v1);
        }
        int i = 0;
        int[] adj = new int[adjV.size()];
        for (Integer x : adjV) {
            adj[i++] = x;
        }
        return adj;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        E = scanner.nextInt();
        for (int i = 0; i < E; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            addEdge(v1, v2);
        }

        int[] a = getAdjVer(1);
        System.out.printf("get adj ver[%d]: ", 1);
        for (int j : a) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println(hasConnect(1, 2));

        removeEdge(1,3);
        addVer(9);
        System.out.printf("get adj ver[%d]: ", 1);
        for (int j : a) {
            System.out.print(j + " ");
        }
        removeVer(2);
    }
}
/*
8 8
1 2
1 3
2 5
2 4
4 8
5 6
5 7
6 7

 */