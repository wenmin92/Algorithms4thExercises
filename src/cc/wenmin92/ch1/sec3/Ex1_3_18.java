package cc.wenmin92.ch1.sec3;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinks;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 假设 x 是一条链表的某个结点且不是尾结点。下面这条语句的效果是什么？
 * x.next = x.next.next;
 * 答：删除 x 的后续结点。
 */
public class Ex1_3_18 {
    public static void main(String[] args) {
        Node<String> links = genLinks(5);

        printLinks(links);

        links.next = links.next.next;

        printLinks(links);

        // output
        // [1 -> 2 -> 3 -> 4 -> 5]
        // [1 -> 3 -> 4 -> 5]
    }
}
