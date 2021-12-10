package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个可迭代的 Stack 用例，它含有一个静态的 copy() 方法，接受一个字符串的栈作为参数
 * 并返回该栈的一个副本。注意：这种能力是迭代器价值的一个重要体现，因为有了它我们无需
 * 改变基本 API 就能够实现这种功能。
 *
 * 解析:
 * 遍历一次栈得到倒序的副本, 需要再次遍历一次.
 */
public class Ex1_3_12 {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < 10; i++) {
            s.push(i + "");
        }
        Stack<String> copied = copy(s);
        StdOut.println(copied);
        StdOut.println(s.toString().equals(copied.toString()));
    }

    public static Stack<String> copy(Stack<String> src) {
        Stack<String> temp = new Stack<>();
        for (String s : src) {
            temp.push(s);
        }
        Stack<String> result = new Stack<>();
        for (String s : temp) {
            result.push(s);
        }
        return result;
    }

}
