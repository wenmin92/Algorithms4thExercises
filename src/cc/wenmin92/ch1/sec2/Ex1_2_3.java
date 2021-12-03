package cc.wenmin92.ch1.sec2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 编写一个 Interval2D 的用例，从命令行接受参数 N、min 和 max。生成 N 个随机的 2D 间隔，其宽
 * 和高均匀地分布在单位正方形中的 min 和 max 之间。用 StdDraw 画出它们并打印出相交的间隔对
 * 的数量以及有包含关系的间隔对数量。
 *
 * 解析: 难点在于包含关系的判断。
 */
public class Ex1_2_3 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        MyInterval2D[] intervals = new MyInterval2D[N];
        for (int i = 0; i < N; i++) {
            double[] xPoints = {StdRandom.uniform(min, max), StdRandom.uniform(min, max)};
            Arrays.sort(xPoints);
            Interval1D x = new Interval1D(xPoints[0], xPoints[1]);
            double[] yPoints = {StdRandom.uniform(min, max), StdRandom.uniform(min, max)};
            Arrays.sort(yPoints);
            Interval1D y = new Interval1D(yPoints[0], yPoints[1]);
            intervals[i] = new MyInterval2D(x, y);
            intervals[i].draw();
        }
        int intersectCount = 0;
        int containCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    intersectCount++;
                }
                if (intervals[i].contains(intervals[j]) || intervals[j].contains(intervals[i])) {
                    containCount++;
                }
            }
        }
        StdOut.println("intersectCount = " + intersectCount);
        StdOut.println("containCount = " + containCount);
    }

    static class MyInterval2D extends Interval2D {
        public final Interval1D x;
        public final Interval1D y;

        public MyInterval2D(Interval1D x, Interval1D y) {
            super(x, y);
            this.x = x;
            this.y = y;
        }

        public boolean contains(MyInterval2D that) {
            return this.x.contains(that.x.min()) && this.x.contains(that.x.max()) && this.y.contains(that.y.min()) && this.y.contains(that.y.max());
        }
    }
}
