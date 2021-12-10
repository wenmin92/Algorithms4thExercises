package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 用环形链表实现 Queue。环形链表也是一条链表，只是没有任何结点的链接为空，且只要链表非
 * 空则 last.next 的值为 first。只能使用一个 Node 类型的实例变量（last）。
 *
 * <pre>
 * Queue API:
 *       void enqueue(Item item)
 *       Item dequeue()
 *    boolean isEmpty()
 *        int size()
 * </pre>
 * <p>
 * #没想出来
 */
public class Ex1_3_29 {
    private static class Queue<T> {
        Node<T> last;
        int n;

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }

        public void enqueue(T item) {
            Node<T> oldLast = last;
            last = new Node<>(item);
            if (oldLast != null) {
                last.next = oldLast.next;
                oldLast.next = last;
            } else {
                last.next = last;
            }
            n++;
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException("Queue underflow");
            }
            T item = last.next.item;
            last.next = last.next.next;
            n--;
            if (isEmpty()) { // 重点
                last = null;
            }
            return item;
        }

        @Override
        public String toString() {
            if (isEmpty()) return "[]";
            Node<T> first = last;
            Node<T> cur = last.next;
            StringBuilder sb = new StringBuilder("[");
            do {
                sb.append(cur.item).append(" -> ");
                cur = cur.next;
            } while (cur != first);
            sb.append(cur.item).append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i + "");
        }
        StdOut.println(q);

        StdOut.print("Dequeued: ");
        for (int i = 0; i < 5; i++) {
            StdOut.print(q.dequeue() + " ");
        }
        StdOut.println();
        StdOut.println(q);

        StdOut.print("Queue: ");
        for (int i = 10; i < 13; i++) {
            StdOut.print(i + " ");
            q.enqueue(i + "");
        }
        StdOut.println();
        StdOut.println(q);
    }
}
