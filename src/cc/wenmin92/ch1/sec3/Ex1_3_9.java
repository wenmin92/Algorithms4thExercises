package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
 * 例如，给定输入：
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * 你的程序应该输出：
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class Ex1_3_9 {
    public static void main(String[] args) {
        Stack<String> vals = new Stack<>();
        Stack<String> ops = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String val = vals.pop();
                vals.push("( " + vals.pop() + " " + ops.pop() + " " + val + " )");
            } else {
                vals.push(s);
            }
        }
        StdOut.println(vals);
    }
}
