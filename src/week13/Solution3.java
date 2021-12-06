package week13;

import java.util.*;

public class Solution3 {
    static class Node implements Comparator<Node> {
        private int vertex;
        private int cost;

        public Node() {}
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        public int getCost() {
            return cost;
        }

        public int getVertex() {
            return vertex;
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.cost < o2.cost) return -1;
            if (o1.cost > o2.cost) return 1;
            return 0;
        }
    }

    private int[] dist;
    private Set<Integer> set;
    private PriorityQueue<Node> pq;
    private int V;
    List<List<Node>> adj;

    public Solution3(int V) {
        this.V = V;
        dist = new int[V];
        set = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    public void dijkstra(List<List<Node>> adj, int start) {
        this.adj = adj;
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE; // gan dist[i] = vo cung lon
        }
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (set.size() != V) {
            if (pq.isEmpty()) return;
            int u = pq.poll().getVertex();

            if (set.contains(u)) {
                continue;
            }
            set.add(u);

            for (int i = 0; i < adj.get(u).size(); i++) {
                Node v = adj.get(u).get(i);

                if (!set.contains(v.vertex)) {
                    int newDist = dist[u] + v.getCost();
                    if (newDist < dist[v.vertex]) {
                        dist[v.getVertex()] = newDist;
                    }

                    pq.offer(new Node(v.getVertex(), dist[v.getVertex()]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Node>> adj = new ArrayList<List<Node>>();
            for (int j = 0; j <= V; j++) adj.add(new ArrayList<Node>());

            for (int j = 0; j < E; j++) {
                int x1 = sc.nextInt();
                int x2 = sc.nextInt();
                int w = sc.nextInt();
                adj.get(x1).add(new Node(x2, w));
                adj.get(x2).add(new Node(x1, w));
            }

            int start = sc.nextInt();
            Solution3 graph = new Solution3(V+1);
            graph.dijkstra(adj, start);

            for (int j = 1; j < graph.dist.length; j++) {
                if (j == start) continue;
                if (graph.dist[j] >= Integer.MAX_VALUE || graph.dist[j] < 0) graph.dist[j] = -1;
                System.out.print(graph.dist[j] + " ");
            }
            System.out.println();
        }
    }
}

/*
0 1 9
0 2 6
0 3 5
0 4 3
2 1 2
2 3 4
 */
