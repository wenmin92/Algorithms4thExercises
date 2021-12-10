package cc.wenmin92.ch1.sec3;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinks;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 编写一个方法 removeAfter()，接受一个链表结点作为参数并删除该结点的后续结点（如果参
 * 数结点或参数结点的后续结点为空则什么也不做）。
 *
 * 解析: 让结点的 next 指向 next 的 next 即可
 */
public class Ex1_3_24 {
    private static void removeAfter(Node<String> links) {
        if (links == null || links.next == null) return;
        links.next = links.next.next;
    }

    public static void main(String[] args) {
        Node<String> links = genLinks(5);
        while(links.next != null) {
            removeAfter(links);
            printLinks(links);
        }

        // output
        // [1 -> 3 -> 4 -> 5]
        // [1 -> 4 -> 5]
        // [1 -> 5]
        // [1]
    }
}
