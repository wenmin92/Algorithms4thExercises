package cc.wenmin92.ch1.sec3;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinks;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 编写一个函数，接受一条链表的首结点作为参数，（破坏性地）将链表反转并返回结果链表的
 * 首结点。
 * <p>
 * 迭代方式的解答：为了完成这个任务，我们需要记录链表中三个连续的结点：reverse、first
 * 和 second。在每轮迭代中，我们从原链表中提取结点 first 并将它插入到逆链表的开头。我们
 * 需要一直保持 first 指向原链表中所有剩余结点的首结点，second 指向原链表中所有剩余结点
 * 的第二个结点，reverse指向结果链表中的首结点。
 * <pre>
 * public Node reverse(Node x)
 * {
 *    Node first   = x;
 *    Node reverse = null;
 *    while (first != null)
 *    {
 *       Node second = first.next;
 *       first.next  = reverse;
 *       reverse     = first;
 *       first       = second;
 *    }
 *    return reverse;
 * }
 * </pre>
 * 在编写和链表相关的代码时，我们必须小心处理异常情况（链表为空或是只有一个或两个结点）
 * 和边界情况（处理首尾结点）。它们通常比处理正常情况要困难得多。
 * <p>
 * 递归解答：假设链表含有 N 个结点，我们先递归颠倒最后 N-1 个结点，然后小心地将原链表中
 * 的首结点插入到结果链表的末端。
 * <pre>
 * public Node reverse(Node first)
 * {
 *    if (first == null) return null;
 *    if (first.next == null) return first;
 *    Node second = first.next;
 *    Node rest = reverse(second);
 *    second.next = first;
 *    first.next  = null;
 *    return rest;
 * }
 * </pre>
 *
 * #递归没想出来
 */
public class Ex1_3_30 {
    /**
     * Method 1: 需要创建额外 node 对象
     */
    private static <T> Node<T> reverse1(Node<T> x) {
        if (x == null) return null;
        Node<T> reverse = new Node<>(x.item);
        Node<T> cur = x.next;
        while (cur != null) {
            reverse = new Node<>(cur.item, reverse);
            cur = cur.next;
        }
        return reverse;
    }

    /**
     * Method 2: 教材原答案 (迭代)
     */
    private static <T> Node<T> reverse2(Node<T> x) {
        Node<T> cur = x;
        Node<T> reverse = null;
        while (cur != null) {
            Node<T> second = cur.next;
            cur.next = reverse;
            reverse = cur;
            cur = second;
        }
        return reverse;
    }

    /**
     * Method 3: 教材原答案 (递归)
     */
    public static <T> Node<T> reverse3(Node<T> x) {
        if (x == null) return null;
        if (x.next == null) return x;
        Node<T> second = x.next;
        Node<T> rest = reverse3(second);
        second.next = x;
        x.next = null;
        return rest;
    }

    public static void main(String[] args) {
        Node<String> links = genLinks(6);
        printLinks(links);
        printLinks(reverse3(links));

        // output
        // [1 -> 2 -> 3 -> 4 -> 5 -> 6]
        // [6 -> 5 -> 4 -> 3 -> 2 -> 1]
    }
}
