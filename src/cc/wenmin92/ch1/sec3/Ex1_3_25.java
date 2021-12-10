package cc.wenmin92.ch1.sec3;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinks;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 编写一个方法 insertAfter()，接受两个链表结点作为参数，将第二个结点插入链表并使之成
 * 为第一个结点的后续结点（如果两个参数为空则什么也不做）。
 */
public class Ex1_3_25 {
    private static void insertAfter(Node<String> first, Node<String> second) {
        if (first == null || second == null) return;
        Node<String> secondEnd = second;
        while (secondEnd.next != null) {
            secondEnd = secondEnd.next;
        }
        secondEnd.next = first.next;
        first.next = second;
    }

    public static void main(String[] args) {
        Node<String> first = genLinks(4, "f");
        Node<String> second = genLinks(3, "s");
        printLinks(first);
        printLinks(second);
        insertAfter(first, second);
        printLinks(first);
        insertAfter(first, new Node<>("ss"));
        printLinks(first);

        // output
        // [f1 -> f2 -> f3 -> f4]
        // [s1 -> s2 -> s3]
        // [f1 -> s1 -> s2 -> s3 -> f2 -> f3 -> f4]8/

        // [f1 -> ss -> s1 -> s2 -> s3 -> f2 -> f3 -> f4]
    }
}
