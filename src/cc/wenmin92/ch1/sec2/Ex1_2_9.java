package cc.wenmin92.ch1.sec2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 修改 BinarySearch（请见 1.1.10.1 节中的二分查找代码），使用 Counter 统计在有查找中被检
 * 查的键的总数并在查找全部结束后打印该值。提示：在 main() 中创建一个 Counter 对象并将它
 * 作为参数传递给 rank()。
 */
public class Ex1_2_9 {
    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();
        Arrays.sort(a);
        Counter counter = new Counter("rank");
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int index = BinarySearch.rank(a, key, counter);
            if (index == -1) {
                StdOut.println("not found");
            } else {
                StdOut.println(index);
            }
        }
        StdOut.println(counter);
    }

    public static class BinarySearch {
        public static int rank(int[] a, int key, Counter counter) {  // 数组必须是有序的
            int lo = 0;
            int hi = a.length - 1;
            while (lo <= hi) { // 被查找的键要么不存在，要么必然存在于 a[lo..hi] 之中
                counter.increment();
                int mid = lo + (hi - lo) / 2;
                if (key < a[mid]) hi = mid - 1;
                else if (key > a[mid]) lo = mid + 1;
                else return mid;
            }
            return -1;
        }
    }
}
