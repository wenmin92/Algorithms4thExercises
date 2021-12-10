package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个过滤器 InfixToPostfix，将算术表达式由中序表达式转为后序表达式。
 *
 * 举例:
 * ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 * 2 3 4 + 5 6 * * +
 *
 * ( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )
 * 5 7 1 1 + * + 3 * 2 1 1 + * +
 *
 * 解析:
 * 后序表达式也称逆波兰表示法, 中序表示法 ( 3 - ( 4 + 5 ) ) 用后序表示法为 3 4 5 + -
 *
 * #没想出来
 */
public class Ex1_3_10 {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                StdOut.print(ops.pop() + " ");
            } else if (!s.equals("(")) {
                StdOut.print(s + " ");
            }
        }
    }
}
