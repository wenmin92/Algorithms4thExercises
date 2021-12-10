package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个 Queue 的用例，接受一个命令行参数 k 并打印出标准输入中的倒数第 k 个字符串（假
 * 设标准输入中至少有 k 个字符串）。
 *
 * 解析:
 * 由于要求使用 Queue, 先全部入队, 然后算出是正数第几个, 把它前面的出列, 剩下的第一个元素就是要求的元素.
 */
public class Ex1_3_15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> q = new Queue<>();

        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }

        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.dequeue();
        }

        StdOut.println(q.dequeue());
    }
}
