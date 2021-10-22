package week7;

import java.util.ArrayList;
import java.util.List;

public class IntoTutorialChallenges {
    public static int introTutorial(int V, List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == V) return mid;
            if (arr.get(mid) < V) left = mid + 1;
            if (arr.get(mid) > V) right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(4);
        arr.add(5);
        arr.add(7);
        arr.add(9);
        arr.add(12);
        System.out.println(introTutorial(4,arr));
    }
}
