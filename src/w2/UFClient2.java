package w2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UFClient2 {
    private int id[];
    private int sz[];
    private int count = 0;

    public UFClient2(int n) {
        count = n;
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if(i == j) return;
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        int indexCouple = 0;
        int N = StdIn.readInt();
        UFClient2 wuf = new UFClient2(N);
        while (wuf.getCount() != 1 && !StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            indexCouple++;
            if (!wuf.connected(p, q)) {
                wuf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }

        if (wuf.getCount() == 1) {
            StdOut.println(indexCouple);
        } else {
            StdOut.println("FAILED");
        }
    }
}

// java -cp d:\DSA\algs4.jar;. UF.UFClient2 < d:\algs4-data\tinyUF.txt
// javac -cp d:\DSA\algs4.jar;. UF.UFClient2.java