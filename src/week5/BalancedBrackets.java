package week5;

import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;

public class BalancedBrackets {
    public static boolean check(String[] s) {
        StackSetUpLlist<String> pair = new StackSetUpLlist<>();
        for (String value : s) {
            if (pair.isEmpty()) {
                pair.push(value);
            } else {
                if (pair.top().equals("(") && value.equals(")")) pair.pop();
                else if (pair.top().equals("{") && value.equals("}")) pair.pop();
                else if (pair.top().equals("[") && value.equals("]")) pair.pop();
                else pair.push(value);
            }
        }
        return pair.isEmpty();
    }
    public static void main(String[] args) {
        String[] s = {"{", "}", "(", "[","]", ")"};
        if (check(s)) StdOut.println("true");
        else StdOut.println("fail");
        StackSetUpLlist<String> st = new StackSetUpLlist<>();
        for (String value : s) {
            st.push(value);
        }
        StdOut.println("size of stack: " + st.size());
    }
}
