package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdOut;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinks;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 编写一个方法 delete()，接受一个 int 参数 k，删除链表的第 k 个元素（如果它存在的话）。
 * <p>
 * #参考他人
 */
public class Ex1_3_20 {
    private static Node<String> delete(Node<String> first, int k) {
        if (first == null || k < 0) {
            throw new IllegalArgumentException();
        }
        if (k == 0) {
            return first.next;
        }
        Node<String> cur = first;
        while (--k > 0) { // 关键 1
            cur = cur.next;
            if (cur.next == null) { // 关键 2
                throw new IndexOutOfBoundsException();
            }
        }
        cur.next = cur.next.next;
        return first;
    }

    public static void main(String[] args) {
        Node<String> first;

        Node<String> deleteFirst = genLinks(3);
        printLinks(deleteFirst);
        first = delete(deleteFirst, 0);
        printLinks(first);

        StdOut.println("---");

        Node<String> deleteSecond = genLinks(3);
        printLinks(deleteSecond);
        first = delete(deleteSecond, 1);
        printLinks(first);

        StdOut.println("---");

        Node<String> deleteThird = genLinks(3);
        printLinks(deleteThird);
        first = delete(deleteThird, 2);
        printLinks(first);

        StdOut.println("---");

        Node<String> deleteFourth = genLinks(3);
        printLinks(deleteFourth);
        first = delete(deleteFourth, 4);
        printLinks(first);

        // output
        // [1 -> 2 -> 3]
        // [2 -> 3]
        // ---
        // [1 -> 2 -> 3]
        // [1 -> 3]
        // ---
        // [1 -> 2 -> 3]
        // [1 -> 2]
        // ---
        // [1 -> 2 -> 3]
        // Exception in thread "main" java.lang.IndexOutOfBoundsException
    }
}
