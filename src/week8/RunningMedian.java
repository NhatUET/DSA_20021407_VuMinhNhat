package week8;

import java.util.*;

public class RunningMedian {
    private static Queue<Integer> minQ = new PriorityQueue<Integer>((a, b) -> {
        return b.compareTo(a);
    });
    private static Queue<Integer> maxQ = new PriorityQueue<Integer>();

    public static void addNumber(int num) {
        if (minQ.size() > 0 && minQ.peek() >= num) minQ.offer(num);
        else if (maxQ.size() > 0 && maxQ.peek() <= num) maxQ.offer(num);
        else minQ.offer(num);

        if (minQ.size() - maxQ.size() > 1) maxQ.offer(minQ.poll());
        if (maxQ.size() - minQ.size() > 1) minQ.offer(maxQ.poll());
    }

    public static double findMed(){
        if (minQ.size() == maxQ.size()) return (double) (minQ.peek() + maxQ.peek())/(double) 2;
        return (maxQ.size() > minQ.size()) ? maxQ.peek() : minQ.peek();
    }
    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> ans = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            addNumber(a.get(i));
            ans.add(findMed());
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {12,4,5,3,8,7};
        List<Integer> arr = new ArrayList<>();
        for (int x : a) arr.add(x);
        List<Double> ans = runningMedian(arr);
        System.out.println(ans);
    }
}
