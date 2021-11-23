package week11;

import java.util.*;

public class MissingNumber {
    // cach 1 dung hashtable
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int x : brr) {
            if (!map.containsKey(x)) map.put(x, 1);
            else map.put(x, map.get(x) + 1);
        } // n
        for (int x : arr) {
            if (map.containsKey(x)) {
                if (map.get(x) > 1) map.put(x, map.get(x) - 1);
                else map.remove(x);
            }
        } // nlogn

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()) res.add(x.getKey());
        return res;
    }

    // cach 2 dung sort
    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {
        Collections.sort(arr); //nlogn
        Collections.sort(brr);
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr.size() && j < brr.size()) {
            if (arr.get(i) < brr.get(j)) {
                res.add(arr.get(i));
                i++;
            } else if (arr.get(i) > brr.get(j)) {
                res.add(brr.get(j));
                j++;
            } else {
                j++;
                i++;
            }
        } // n
        if (arr.size() > brr.size()) {
            for (; i < arr.size(); i++) {
                res.add(arr.get(i));
            }
        } else if (arr.size() < brr.size()) {
            for (; j < brr.size(); j++) {
                res.add(brr.get(j));
            }
        }
        Collections.sort(res);
        return res;
    }

    // cach 3 dung counting sort
    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        int[] a1 = new int[100000];
        int[] b1 = new int[100000];
        for (int i = 0; i < arr.size(); i++) a1[arr.get(i)]++;
        for (int i = 0; i < brr.size(); i++) b1[brr.get(i)]++;
        for (int i = 0; i < a1.length; i++) {
            if (b1[i] - a1[i] > 1) b1[i] = b1[i] - a1[i];
            if (a1[i] >= b1[i]) b1[i] = 0;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < b1.length; i++) {
            if (b1[i] != 0) res.add(i);
        }
        Collections.sort(res); // O(n)
        return res;
    }
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        int[] a1 = {11, 4, 11, 7, 13, 4, 12, 11, 10, 14};
        int[] b1 = {11 ,4 ,11 ,7 ,3 ,7 ,10 ,13, 4, 8, 12, 11, 10, 14, 12};
        List<Integer> b = new ArrayList<>();
        for (int i= 0; i < a1.length; i++) a.add(a1[i]);
        for (int i= 0; i < b1.length; i++) b.add(b1[i]);
        a = missingNumbers2(a, b);
        System.out.print(a);
    }
}
