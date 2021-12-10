package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 使用 1.3.1.5 节中的 readInts() 作为模板为 Date 编写一个静态方法 readDates()，从标准输入
 * 中读取由练习 1.2.19 的表格所指定的格式的多个日期并返回一个它们的数组。
 */
public class Ex1_3_16 {
    public static void main(String[] args) {
        StdOut.println(Arrays.toString(readDates()));
    }

    public static Date[] readDates() {
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        int N = q.size();
        Date[] dates = new Date[N];
        for (int i = 0; i < N; i++) {
            dates[i] = new Date(q.dequeue());
        }
        return dates;
    }
}
