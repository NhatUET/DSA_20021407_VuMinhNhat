package week12;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adjCity;
    static int DFS(int city) {
        int node = 1;
        visited[city] = true;
        for (int neiCity : adjCity.get(city)) {
            if (!visited[neiCity]) {
               node += DFS(neiCity);
            }
        }
        return node;
    }

    static long min(int c_lib, int c_road, int cities) {
        long cost = 0;
        if (c_lib < c_road) return (long) c_lib * cities;
        else {
            for (int j = 1; j <= cities; j++) {
                if (!visited[j]) {
                    int node = DFS(j);
                    cost = cost + c_lib + (long) c_road * (node - 1);
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        for (int i = 0; i < p; i++) {
            int cities = scanner.nextInt();
            int numRoad = scanner.nextInt();
            int c_lib = scanner.nextInt();
            int c_road = scanner.nextInt();

            adjCity = new ArrayList<ArrayList<Integer>>();
            visited = new boolean[cities+1];
            for (int j = 0; j <= cities; j++) {
                adjCity.add(new ArrayList<Integer>());
            }
            for (int j = 1; j <= numRoad; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                adjCity.get(a).add(b);
                adjCity.get(b).add(a);

                visited[a] = false;
                visited[b] = false;
            }

            System.out.println(min(c_lib, c_road, cities));
        }
    }
}
/*
2
3 3 2 1
1 2
3 1
2 3
6 6 2 5
1 3
3 4
2 4
1 2
2 3
5 6
 */