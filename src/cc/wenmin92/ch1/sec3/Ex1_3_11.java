package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一段程序 EvaluatePostﬁx ，从标准输入中得到一个后序表达式，求值并打印结果（将上一题
 * 的程序中得到的输出用管道传递给这一段程序可以得到和 Evaluate 相同的行为）。
 *
 * 举例:
 * 3 4 5 + *
 * 27
 *
 * 1 2 3 4 5 * + 6 * * +
 * 277
 *
 * 7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +
 * 30001
 *
 * 7 16 * 5 + 16 * 3 + 16 * 1 +
 * 30001
 */
public class Ex1_3_11 {
    public static void main(String[] args) {
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                double v = vals.pop();
                if (s.equals("+")) vals.push(vals.pop() + v);
                else if (s.equals("-")) vals.push(vals.pop() - v);
                else if (s.equals("*")) vals.push(vals.pop() * v);
                else if (s.equals("/")) vals.push(vals.pop() / v);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
