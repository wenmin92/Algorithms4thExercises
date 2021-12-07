package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 为 FixedCapacityStackOfStrings 添加一个方法 isFull()。
 */
public class Ex1_3_1 {
    private static class FixedCapacityStackOfStrings {
        private int N;
        private String[] a;
        private int capacity;

        public FixedCapacityStackOfStrings(int capacity) {
            a = new String[capacity];
            this.capacity = capacity;
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

        public boolean isFull() {
            return N >= capacity;
        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(10);
        for (int i = 0; i < 12; i++) {
            if (!s.isFull()) {
                s.push(i + "");
            } else {
                StdOut.println("Already full");
            }
        }
    }
}
