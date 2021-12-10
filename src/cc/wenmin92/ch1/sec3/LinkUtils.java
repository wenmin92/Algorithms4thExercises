package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdOut;

public class LinkUtils {

    /**
     * 生成指定数量的链表
     */
    public static Node<String> genLinks(int count) {
        return genLinks(null, count, "");
    }

    /**
     * 生成指定数量的链表
     */
    public static Node<String> genLinks(int count, String tag) {
        return genLinks(null, count, tag);
    }

    private static Node<String> genLinks(Node<String> first, int count, String tag) {
        if (count == 0) return first;
        return genLinks(new Node<>(tag + count + "", first), --count, tag);
    }

    /**
     * 生成指定数量的链表 (int 类型)
     */
    public static Node<Integer> genLinkOfNums(int count) {
        return genLinkOfNums(null, count);
    }

    private static Node<Integer> genLinkOfNums(Node<Integer> first, int count) {
        if (count == 0) return first;
        return genLinkOfNums(new Node<>(count, first), --count);
    }

    public static void main(String[] args) {
        LinkUtils.printLinks(genLinks(5)); // [1 -> 2 -> 3 -> 4 -> 5]
    }

    /**
     * 打印链表内容, 形如 [1 -> 2 -> 3 -> 4 -> 5]
     */
    public static <T> void printLinks(Node<T> first) {
        if (first == null) {
            StdOut.println("[]");
            return;
        }
        StdOut.print("[");
        while (first.next != null) {
            StdOut.print(first.item + " -> ");
            first = first.next;
        }
        StdOut.println(first.item + "]");
    }
}
