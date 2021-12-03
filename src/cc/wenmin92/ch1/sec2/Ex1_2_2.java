package cc.wenmin92.ch1.sec2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一个 Interval1D 的用例，从命令行接受一个整数 N。从标准输入中读取 N 个间隔（每个间隔
 * 由一对 double 值定义）并打印出所有相交的间隔对。
 */
public class Ex1_2_2 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Interval1D[] intervals = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            intervals[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.println(intervals[i] + " intersects " + intervals[j]);
                }
            }
        }
    }
}
