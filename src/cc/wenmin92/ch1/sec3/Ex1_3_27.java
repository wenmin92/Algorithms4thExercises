package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinkOfNums;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 编写一个方法 max()，接受一条链表的首结点作为参数，返回链表中键最大的节点的值。假设所
 * 有键均为正整数，如果链表为空则返回 0。
 */
public class Ex1_3_27 {
    private static int max(Node<Integer> links) {
        int max = 0;
        Node<Integer> cur = links;
        while (cur != null) {
            if (max < cur.item) max = cur.item;
            cur = cur.next;
        }
        return max;
    }

    public static void main(String[] args) {
        Node<Integer> links1 = new Node<>(StdRandom.uniform(100), new Node<>(StdRandom.uniform(100), new Node<>(StdRandom.uniform(100), new Node<>(StdRandom.uniform(100)))));
        printLinks(links1);
        StdOut.println("max: " + max(links1));

        Node<Integer> links2 = new Node<>(StdRandom.uniform(100));
        printLinks(links2);
        StdOut.println("max: " + max(links2));

        Node<Integer> links3 = null;
        printLinks(links3);
        StdOut.println("max: " + max(links3));

        // output
        // [13 -> 65 -> 73 -> 66]
        // max: 73
        // [25]
        // max: 25
        // []
        // max: 0
    }
}
