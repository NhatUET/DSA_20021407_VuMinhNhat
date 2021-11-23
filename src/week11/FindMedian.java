package week11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class FindMedian {

    public static void addNumber(int num, TreeSet<Integer> maxTreeSet, TreeSet<Integer> minTreeSet) {
        if (minTreeSet.size() > 0 && minTreeSet.first() >= num) minTreeSet.add(num);
        else if (maxTreeSet.size() > 0 && maxTreeSet.last() <= num) maxTreeSet.add(num);
        else minTreeSet.add(num);

        if (minTreeSet.size() - maxTreeSet.size() > 1) maxTreeSet.add(minTreeSet.pollFirst());
        if (maxTreeSet.size() - minTreeSet.size() > 1) minTreeSet.add(maxTreeSet.pollLast());
    }

    public static double findMed(TreeSet<Integer> maxTreeSet, TreeSet<Integer> minTreeSet){
        if (minTreeSet.size() == maxTreeSet.size()) {
            return (double) (minTreeSet.first() + maxTreeSet.last())/(double) 2;
        }
        return (maxTreeSet.size() > minTreeSet.size()) ? maxTreeSet.last() : minTreeSet.first();
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> ans = new ArrayList<>();
        TreeSet<Integer> maxTreeSet = new TreeSet<>();
        TreeSet<Integer> minTreeSet = new TreeSet<>();
        for (Integer integer : a) {
            addNumber(integer, maxTreeSet, minTreeSet);
            ans.add(findMed(maxTreeSet, minTreeSet));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {12, 4, 5, 3, 8, 7};
        List<Integer> arr = new ArrayList<>();
        for (int j : a) {
            arr.add(j);
        }
        System.out.print(runningMedian(arr));
    }
    // [12.0, 8.0, 5.0, 4.5, 5.0, 6.0]
}
