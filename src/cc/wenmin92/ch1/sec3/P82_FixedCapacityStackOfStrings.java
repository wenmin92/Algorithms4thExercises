package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 一种表示定容字符串栈的抽象数据类型
 * 测试数据: data/tobe.txt
 */
public class P82_FixedCapacityStackOfStrings {

    private String[] a;
    private int N;

    public P82_FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public static void main(String[] args) {
        P82_FixedCapacityStackOfStrings s = new P82_FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)"); // result: to be not that or be (2 left on stack)
    }
}
