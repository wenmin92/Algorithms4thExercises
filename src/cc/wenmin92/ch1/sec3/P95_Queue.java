package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class P95_Queue<Item> {
    private static class Node<Item> {
        Node<Item> next;
        Item item;
    }

    private Node<Item> first;
    private Node<Item> last;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    public static void main(String[] args) {
        P95_Queue<String> q = new P95_Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                q.enqueue(item);
            } else if (!q.isEmpty()) {
                StdOut.print(q.dequeue() + " ");
            }
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
