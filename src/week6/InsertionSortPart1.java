package week6;

import java.util.List;

public class InsertionSortPart1 {
    public static void print(List<Integer> arr)
    {
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
    public static void insertionSort1(int n, List<Integer> arr) {
        int a = arr.get(n - 1);
        for(int i=n-2;i>=0;i--)
        {
            if(arr.get(i) <a)
            {
                arr.set(i+1,a);
                print(arr);
                break;
            }
            else
            {
                arr.set(i + 1, arr.get(i));
                print(arr);
                if(i==0)
                {
                    arr.set(i, a);
                    print(arr);
                }
            }
        }
    }
}
