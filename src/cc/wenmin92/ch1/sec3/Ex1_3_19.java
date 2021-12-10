package cc.wenmin92.ch1.sec3;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinks;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 给出一段代码，删除链表的尾结点，其中链表的首结点为 first。
 * <p>
 * 解析: 为了删除尾结点, 需要尾结点的前一个结点的引用
 * 假设结点数多于2个, 建立一个结点引用 cur 表示当前结点, 移动到尾结点的前一个结点, 将该节点的 next 设为 null.
 */
public class Ex1_3_19 {
    /**
     * 至少需要2个节点
     */
    private static void deleteLast(Node<String> first) {
        Node<String> cur = first;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
    }

    public static void main(String[] args) {
        Node<String> links = genLinks(5);

        printLinks(links);

        deleteLast(links);

        printLinks(links);

        // output
        // [1 -> 2 -> 3 -> 4 -> 5]
        // [1 -> 2 -> 3 -> 4]
    }
}
