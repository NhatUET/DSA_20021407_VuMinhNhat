package week8;

import java.util.*;

public class CountingWordNoTreeMap {
    public static void Count(String s) {
        String[] words = s.split("\\s+");
        Set<String> set = new TreeSet<String>();
        Collections.addAll(set, words);
        int[] a = new int[words.length+1];
        Iterator<String> iterator = set.iterator();
        int j = 0;
        for (String key : set) {
            for (String word : words) {
                if (key.equals(word)) a[j]+=1;
            }
            j++;
        }
        int k = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + ":" + a[k++]);
        }
    }
    public static void main(String[] args) {
        String s = "Viết một chương trình đọc một chuỗi văn bản từ input chuẩn" +
                " (hoặc file tùy bạn) đếm số lần xuất hiện của mỗi từ trong văn bản, in ra " +
                "kết quả là danh sách các từ theo thứ tự từ điển kèm theo số lần xuất hiện. " +
                "Hãy viết mà không dùng các cấu trúc HashMap hoặc TreeMap sẵn có trong thư viện của java. " +
                "Sau khi chương trình chạy đúng với dữ liệu nhỏ, hãy thử với dữ liệu văn bản lớn. " +
                "Nếu chương trình của bạn chạy chậm, hãy nghĩ cách cải tiến cấu trúc dữ liệu và giải thuật của bạn. " +
                "Sau khi cải tiến xong hoặc không cải tiến được, bạn hãy thử dùng TreeMap.";
        Count(s);
    }
}
