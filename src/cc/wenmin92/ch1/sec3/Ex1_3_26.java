package cc.wenmin92.ch1.sec3;

import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 编写一个方法 remove()，接受一条链表和一个字符串 key 作为参数，删除链表中所有 item 域
 * 为 key 的结点。
 *
 * 解析:
 * 为避免过多的判断语句 (比如: 判断传入的 list 是否为 null, 判断头结点是否就是需要删除的结点),
 * 在方法内部使用一个虚拟的头结点指向作为参数传入的结点
 * 然后从该虚拟头结点开始逐项检查, 看当前结点的后续是否就是满足删除条件的结点, 若是就删除, 不是就再往后遍历
 * 最后返回该虚拟头结点的后续
 *
 * #没想出来
 */
public class Ex1_3_26 {
    private static <T> Node<T> remove(Node<T> links, T key) {
        Node<T> head = new Node<>(null, links);
        Node<T> cur = head;
        while (cur.next != null) {
            if (key.equals(cur.next.item))
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node<String> links = new Node<>("2", new Node<>("2", new Node<>("3", new Node<>("4"))));
        printLinks(links);
        links = remove(links, "2");
        printLinks(links);
        links = remove(links, "3");
        printLinks(links);
        links = remove(links, "4");
        printLinks(links);
        links = remove(links, "4");
        printLinks(links);

        // output
        // [2 -> 2 -> 3 -> 4]
        // [3 -> 4]
        // [4]
        // []
        // []
    }
}
