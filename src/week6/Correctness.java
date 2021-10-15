package week6;

import java.util.Scanner;

public class Correctness {
    public static void insertionSort(int[] A){
        for (int i = 1; i < A.length; i++) {
            for (int j = i; j > 0; j--) {
                if (A[j] < A[j-1]) {
                    int tmp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = tmp;
                } else {
                    break;
                }
            }
        }
        printArray(A);
    }
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}
