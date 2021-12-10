package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 编写一个类 ResizingArrayQueueOfStrings，使用定长数组实现队列的抽象，然后扩展实现，
 * 使用调整数组的方法突破大小的限制。
 * <p>
 * <pre>
 * Queue API:
 *       void enqueue(Item item)
 *       Item dequeue()
 *    boolean isEmpty()
 *        int size()
 * </pre>
 * <p>
 * 解析: 目前的方法效率不高, 官网给出了更好的方法 https://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html
 */
public class Ex1_3_14 {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-")) {
                q.enqueue(s);
            } else if (!q.isEmpty()) {
                StdOut.print(q.dequeue() + " ");
            }
        }
        StdOut.println("(" + q.size() + " left)");
        StdOut.println(q);
    }

    private static class ResizingArrayQueueOfStrings {

        private int N = 0;
        private String[] a = new String[1];

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void enqueue(String item) {
            if (N == a.length) {
                resize(a.length * 2);
            }
            a[N++] = item;
        }

        public String dequeue() {
            String item = a[0];
            for (int i = 1; i < N; i++) {
                a[i - 1] = a[i];
            }
            N--;
            if (N > 0 && N == a.length / 4) {
                resize(a.length / 2);
            }
            return item;
        }

        private void resize(int capacity) {
            String[] temp = new String[capacity];
            for (int i = 0; i < N; i++) {
                temp[i] = a[i];
            }
            a = temp;
        }

        @Override
        public String toString() {
            return "ResizingArrayQueueOfStrings{" +
                    "N=" + N +
                    ", a.length=" + a.length +
                    ", a=" + Arrays.toString(a) +
                    '}';
        }
    }
}
