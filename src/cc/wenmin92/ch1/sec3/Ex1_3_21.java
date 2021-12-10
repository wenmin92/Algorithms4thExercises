package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdOut;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinks;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 编写一个方法 find()，接受一条链表和一个字符串 key 作为参数。如果链表中的某个结点的
 * item 域的值为 key，则方法返回 true，否则返回 false。
 */
public class Ex1_3_21 {
    private static boolean find(Node<String> first, String key) {
        Node<String> cur = first;
        while (cur != null) {
            if (key.equals(cur.item)) return true;
            cur = cur.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node<String> links = genLinks(4);
        printLinks(links);
        StdOut.println(find(links, "4"));
        StdOut.println(find(links, "5"));

        // output
        // [1 -> 2 -> 3 -> 4]
        // true
        // false
    }
}
