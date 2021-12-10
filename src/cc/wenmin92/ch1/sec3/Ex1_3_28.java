package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 用递归的方法解答上一道练习。
 *
 * #别人方法更好
 */
public class Ex1_3_28 {
    // private static int max(Node<Integer> links, int max) {
    //     if (links == null) {
    //         return max;
    //     }
    //     if (max < links.item) max = links.item;
    //     return max(links.next, max);
    // }

    private static int max(Node<Integer> links) {
        if (links == null) return 0;
        return Math.max(links.item, max(links.next));
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
