package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 实现一个嵌套类 DoubleNode 用来构造双向链表，其中每个结点都含有一个指向前驱元素的引用
 * 和一项指向后续元素的引用（如果不存在则为 null）。为以下任务实现若干静态方法：在表头
 * 插入结点、在表尾插入结点、从表头删除结点、从表尾删除结点、在指定结点之前插入新结点、
 * 在指定结点之后插入新结点、删除指定结点。
 */
public class Ex1_3_31 {
    private static class DoubleNode<T> {
        T item;
        DoubleNode<T> next;
        DoubleNode<T> pre;
    }

    public static <T> DoubleNode<T> insertHead(DoubleNode<T> first, T item) {
        DoubleNode<T> lastFirst = first;
        first = new DoubleNode<>();
        first.item = item;
        first.next = lastFirst;
        lastFirst.pre = first;
        return first;
    }

    public static <T> void insertTail(DoubleNode<T> first, T item) {
        DoubleNode<T> n = new DoubleNode<>();
        n.item = item;
        DoubleNode<T> tail = first;
        while (tail.next != null) {
            tail = tail.next;
        }
        n.pre = tail;
        tail.next = n;
    }

    public static <T> DoubleNode<T> deleteHead(DoubleNode<T> first) {
        if (first == null || first.next == null) return null;
        first.next.pre = null;
        return first.next;
    }

    public static <T> DoubleNode<T> deleteTail(DoubleNode<T> first) {
        if (first == null || first.next == null) return null;

        DoubleNode<T> tail = first;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.pre.next = null;
        return first;
    }

    public static <T> DoubleNode<T> insertBefore(DoubleNode<T> first, T target, T item) {
        DoubleNode<T> cur = first;
        while (cur != null) {
            if (target.equals(cur.item)) {
                DoubleNode<T> oldPre = cur.pre;
                cur.pre = new DoubleNode<>();
                cur.pre.item = item;
                cur.pre.next = cur;
                if (oldPre != null) {
                    cur.pre.pre = oldPre;
                    oldPre.next = cur.pre;
                    return first;
                }
                return cur.pre;
            }
            cur = cur.next;
        }
        return first;
    }

    public static <T> void insertAfter(DoubleNode<T> first, T target, T item) {
        DoubleNode<T> cur = first;
        while (cur != null) {
            if (target.equals(cur.item)) {
                DoubleNode<T> oldNext = cur.next;
                cur.next = new DoubleNode<>();
                cur.next.item = item;
                cur.next.pre = cur;
                if (oldNext != null) {
                    cur.next.next = oldNext;
                    oldNext.pre = cur.next;
                }
                return;
            }
            cur = cur.next;
        }
    }

    public static <T> void printLinks(DoubleNode<T> first) {
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

    public static <T> DoubleNode<T> delete(DoubleNode<T> first, T target) {
        DoubleNode<T> cur = first;
        while (cur != null) {
            if (target.equals(cur.item)) {
                if (cur.pre != null) {
                    cur.pre.next = cur.next;
                }
                if (cur.next != null) {
                    cur.next.pre = cur.pre;
                }
                if (cur.pre == null) {
                    return cur.next;
                }
                return first;
            }
            cur = cur.next;
        }
        return first;
    }

    public static <T> DoubleNode<T> deleteAll(DoubleNode<T> first, T target) {
        DoubleNode<T> cur = first;
        while (cur != null) {
            if (target.equals(cur.item)) {
                if (cur.pre != null) {
                    cur.pre.next = cur.next;
                }
                if (cur.next != null) {
                    cur.next.pre = cur.pre;
                }
                if (cur.pre == null) {
                    first = cur.next;
                }
            }
            cur = cur.next;
        }
        return first;
    }

    public static void main(String[] args) {
        DoubleNode<Integer> first = new DoubleNode<>();
        first.item = 0;
        StdOut.print("Start: ");
        printLinks(first);

        first = insertHead(first, 1);
        first = insertHead(first, 2);
        first = insertHead(first, 1);
        first = insertHead(first, 2);
        StdOut.print("insertHead: ");
        printLinks(first);

        insertTail(first, 3);
        insertTail(first, 4);
        insertTail(first, 3);
        insertTail(first, 4);
        StdOut.print("insertTail: ");
        printLinks(first);

        first = deleteHead(first);
        StdOut.print("deleteHead: ");
        printLinks(first);

        first = deleteTail(first);
        StdOut.print("deleteTail: ");
        printLinks(first);

        first = insertBefore(first, 1, 5);
        first = insertBefore(first, 3, 6);
        StdOut.print("insertBefore: ");
        printLinks(first);

        insertAfter(first, 3, 7);
        insertAfter(first, 5, 8);
        StdOut.print("insertAfter: ");
        printLinks(first);

        first = delete(first, 5);
        first = delete(first, 7);
        StdOut.print("delete: ");
        printLinks(first);

        first = deleteAll(first, 3);
        StdOut.print("deleteAll: ");
        printLinks(first);

        // output
        // Start: [0]
        // insertHead: [2 -> 1 -> 2 -> 1 -> 0]
        // insertTail: [2 -> 1 -> 2 -> 1 -> 0 -> 3 -> 4 -> 3 -> 4]
        // deleteHead: [1 -> 2 -> 1 -> 0 -> 3 -> 4 -> 3 -> 4]
        // deleteTail: [1 -> 2 -> 1 -> 0 -> 3 -> 4 -> 3]
        // insertBefore: [5 -> 1 -> 2 -> 1 -> 0 -> 6 -> 3 -> 4 -> 3]
        // insertAfter: [5 -> 8 -> 1 -> 2 -> 1 -> 0 -> 6 -> 3 -> 7 -> 4 -> 3]
        // delete: [8 -> 1 -> 2 -> 1 -> 0 -> 6 -> 3 -> 4 -> 3]
        // deleteAll: [8 -> 1 -> 2 -> 1 -> 0 -> 6 -> 4]
    }

}
