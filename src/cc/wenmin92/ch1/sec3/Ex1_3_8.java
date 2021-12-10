package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 给定以下输入，给出 DoublingStackOfStrings 的数组的内容和大小。
 * it was - the best - of times - - - it was - the - -
 * <p>
 * 解析: 按照 https://alg4.ikesnowy.com/1-3-8/ 提示, 这里 DoublingStackOfStrings 应该是类似 ResizingArrayStack 的
 *
 *  --------------------------------------------------------------------------------------------------
 *   StdIn    StdOut  N   a.length    0       1       2       3       4       5       6       7
 *  --------------------------------------------------------------------------------------------------
 *                    0       1       null
 *   it               1       1       it
 *   was              2       2       it      was
 *   -                1       2       it      null
 *   the              2       2       it      the
 *   best             3       4       it      the     best    null
 *   -                2       4       it      the     null    null
 *   of               3       4       it      the     of      null
 *   times            4       4       it      the     of      times
 *   -                3       4       it      the     of      null
 *   -                2       4       it      the     null    null
 *   -                1       2       it      null
 *   it               2       2       it      it
 *   was              3       4       it      it      was     null
 *   -                2       4       it      it      null    null
 *   the              3       4       it      it      the     null
 *   -                2       4       it      it      null    null
 *   -                1       2       it      null
 *  --------------------------------------------------------------------------------------------------
 */
public class Ex1_3_8 {
    private static class DoublingStackOfStrings {
        private String[] a = new String[1];
        private int N = 0;

        public int size() {
            return N;
        }

        public void push(String item) {
            if (a.length == N) {
                resize(a.length * 2);
            }
            a[N++] = item;
        }

        public String pop() {
            String item = a[--N];
            a[N] = null;
            if (N > 0 && N == a.length / 4) {
                resize(a.length / 2);
            }
            return item;
        }

        private void resize(int capacity) {
            String[] newArray = new String[capacity];
            for (int i = 0; i < N; i++) {
                newArray[i] = a[i];
            }
            a = newArray;
        }

        public String toString() {
            return "size: " + N + ", array length: " + a.length;
        }
    }

    public static void main(String[] args) {
        DoublingStackOfStrings s = new DoublingStackOfStrings();
        String input = "it was - the best - of times - - - it was - the - -";
        String[] items = input.split(" ");
        for (String item : items) {
            if (!item.equals("-")) {
                s.push(item);
            } else {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left)");
        StdOut.println("DoublingStackOfStrings: " + s);
    }
}
