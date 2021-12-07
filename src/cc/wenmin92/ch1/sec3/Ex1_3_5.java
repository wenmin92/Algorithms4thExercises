package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 当 N 为 50 时下面这段代码会打印什么？从较高的抽象层次描述给定正整数 N 时这段代码的行为。
 * <pre>
 * Stack<Integer> stack = new Stack<Integer>();
 * while (N > 0)
 * {
 *    stack.push(N % 2);
 *    N = N / 2;
 * }
 * for (int d : stack) StdOut.print(d);
 * StdOut.println();
 * </pre>
 * 答：打印 N 的二进制表示（当 N 为 50 时打印 110010）。
 */
public class Ex1_3_5 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Stack<Integer> stack = new Stack<>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
