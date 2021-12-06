package week13;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution2 {
    static class Cost implements Comparable<Cost> {
        private int vertex;
        private int weight;

        public Cost(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int other() {
            return vertex;
        }

        public int weight() {
            return weight;
        }

        @Override
        public int compareTo(Cost other) {
            return Integer.compare(weight, other.weight);
        }
    }

    static boolean[] visited;
    static int totalCost;
    static int numE; // number of edges
    static PriorityQueue<Cost> priorityQueue;

    static void Prim(ArrayList<ArrayList<Cost>> graph, int start) {
        visit(graph, start);
        while (!priorityQueue.isEmpty() && numE < graph.size() - 2) {
            Cost c = priorityQueue.poll();
            int w = c.other();
            if (visited[w]) continue;
            totalCost += c.weight();
            numE++;
            visit(graph, w);
        }
    }

    static void visit(ArrayList<ArrayList<Cost>> graph, int v) {
        visited[v] = true;
        for (Cost edge : graph.get(v)) {
            if (!visited[edge.other()]) {
                priorityQueue.offer(edge);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();

        // init graph
        ArrayList<ArrayList<Cost>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Cost>());
        }
        visited = new boolean[V + 1];
        priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            int v = sc.nextInt(), w = sc.nextInt(), weight = sc.nextInt();
            graph.get(v).add(new Cost(w, weight));
            graph.get(w).add(new Cost(v, weight));
        }
        int start = sc.nextInt();

        Prim(graph, start);
        System.out.println(totalCost);
    }
}

/*
test
5 6
1 2 3
1 3 4
4 2 6
5 2 2
2 3 5
3 5 7
1
 */