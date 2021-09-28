package w3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class closetNum {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        List<Integer> dif = new ArrayList<>(arr.size());
        int min = Integer.MAX_VALUE;
        Collections.sort(arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) < min) {
                min = arr.get(i) - arr.get(i - 1);
            }
        }
        for (int i = 1; i < arr.size(); i++) {
            if (min == arr.get(i) - arr.get(i - 1)) {
                dif.add(arr.get(i - 1));
                dif.add(arr.get(i));
            }
        }
        return dif;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
