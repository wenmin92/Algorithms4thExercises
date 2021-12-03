package cc.wenmin92.ch1.sec2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 编写一个 Point2D 的用例，从命令行接受一个整数 N。在单位正方形中生成 N 个随机点，然后计
 * 算两点之间的最近距离。
 */
class Ex1_2_1 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            Point2D point = new Point2D(StdRandom.uniform(), StdRandom.uniform());
            points[i] = point;
        }

        double minDistance = Double.POSITIVE_INFINITY;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        StdOut.println(minDistance);
    }
}
