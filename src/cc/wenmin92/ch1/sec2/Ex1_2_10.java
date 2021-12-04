package cc.wenmin92.ch1.sec2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex1_2_10 {
    public static void main(String[] args) {
        VisualCounter vc = new VisualCounter(100, 50);
        for (int i = 0; i < 102; i++) {
            if (StdRandom.bernoulli()) {
                vc.increment();
            } else {
                vc.decrement();
            }
        }
        StdOut.println(vc.tally());
    }

    public static class VisualCounter {
        private final int N; // 操作的最大次数
        private final int max; // 计数器的最大绝对值
        private int count = 0; // 计数器的当前值
        private int n = 0; // 当前操作的次数

        public VisualCounter(int N, int max) {
            this.N = N;
            this.max = max;
            StdDraw.setXscale(0, N);
            StdDraw.setYscale(-max, max);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.setPenRadius(0.001);
            StdDraw.line(0, 0, N, 0);
            StdDraw.line(0, -max, 0, max);

            StdDraw.setPenColor(StdDraw.ORANGE);
            StdDraw.setPenRadius(0.01);
        }

        public void increment() {
            if (n < N && count < max) {
                count++;
                n++;
                StdDraw.point(n, count);
            } else {
                StdOut.println("计数器已经达到最大绝对值或者超过最大次数");
            }
        }

        public void decrement() {
            if (n < N && count > -max) {
                count--;
                n++;
                StdDraw.point(n, count);
            } else {
                StdOut.println("计数器已经达到最大绝对值或者超过最大次数");
            }
        }

        public int tally() {
            return count;
        }

        public String toString() {
            return String.format("%d/%d", count, N);
        }
    }
}
