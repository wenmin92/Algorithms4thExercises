package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个 Stack 的用例 Parentheses，从标准输入中读取一个文本流并使用栈判定其中的括
 * 号是否配对完整。例如，对于 [()]{}{[()()]()} 程序应该打印 true，对于 [(]) 则打印
 * false。
 */
public class Ex1_3_4 {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        while (!StdIn.isEmpty()) {
            char item = StdIn.readChar();
            if (item == '(' || item == '[' || item == '{') {
                s.push(item);
            } else if (item == ')') {
                if (s.pop() != '(') {
                    StdOut.println(false);
                    return;
                }
            } else if (item == ']') {
                if (s.pop() != '[') {
                    StdOut.println(false);
                    return;
                }
            } else if (item == '}') {
                if (s.pop() != '{') {
                    StdOut.println(false);
                    return;
                }
            }
        }
        StdOut.println(s.isEmpty()); // 涵盖括号数量不匹配的情况
    }
}
