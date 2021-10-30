package week8;

import java.util.*;

public class JesseAndCookies {
    public static int cookies(int k, List<Integer> a) {
        Queue<Integer> pQueue = new PriorityQueue<Integer>();
        pQueue.addAll(a);
        int count = 0;
        if (pQueue.peek() >= k) return -1;
        while (pQueue.size() > 1) {
            int m1 = pQueue.poll();
            if (m1 >= k) break;
            if (m1 < k) {
                int m2 = pQueue.poll();
                pQueue.add(m1 + m2 * 2);
                count++;
            }
        }
        if (pQueue.size() == 1) {
            if (pQueue.peek() >= k) return count;
            return -1;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] a = {2,7,3,6,4,6};
        List<Integer> arr = new ArrayList<Integer>();
        for (int x : a) {
            arr.add(x);
        }
        System.out.println(cookies(9,arr));
    }
}
