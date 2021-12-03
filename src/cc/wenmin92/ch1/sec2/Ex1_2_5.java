package cc.wenmin92.ch1.sec2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 以下这段代码会打印出什么？
 * <pre>
 * String s = "Hello World";
 * s.toUpperCase();
 * s.substring(6, 11);
 * StdOut.println(s);
 * </pre>
 * 答："Hello World"。String对象是不可变的——所有字符串方法都会返回一个新的 String对象
 * （但它们不会改变参数对象的值）。这段代码忽略了返回的对象并直接打印了原字符串。要打印出
 * "WORLD"，请用 s = s.toUpperCase()和 s = s.substring(6, 11)。
 */
public class Ex1_2_5 {
    public static void main(String[] args) {
        String s = "Hello, World!";
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s);
        // Hello, World!
    }
}
