package cc.wenmin92.ch1.sec2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 以下这段代码会打印出什么？
 * <pre>
 * String string1 = "hello";
 * String string2 = string1;
 * string1 = "world";
 * StdOut.println(string1);
 * StdOut.println(string2);
 * </pre>
 */
public class Ex1_2_4 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
        // world
        // hello
    }
}
