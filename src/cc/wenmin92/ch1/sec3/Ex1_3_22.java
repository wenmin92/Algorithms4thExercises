package cc.wenmin92.ch1.sec3;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinks;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 假设 x 是一条链表中的某个结点，下面这段代码做了什么？
 * t.next = x.next;
 * x.next = t;
 * 答：插入结点 t 并使它成为 x 的后续结点。
 */
public class Ex1_3_22 {
    public static void main(String[] args) {
        Node<String> links = genLinks(5);
        Node<String> t = new Node<>("t");

        printLinks(links);

        t.next = links.next;
        links.next = t;

        printLinks(links);

        // output
        // [1 -> 2 -> 3 -> 4 -> 5]
        // [1 -> t -> 2 -> 3 -> 4 -> 5]
    }
}
