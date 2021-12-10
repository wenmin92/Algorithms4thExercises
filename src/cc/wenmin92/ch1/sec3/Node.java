package cc.wenmin92.ch1.sec3;

public class Node<T> {
    public T item;
    public Node<T> next;

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    public Node(T item) {
        this(item, null);
    }

    public Node() {
        this(null, null);
    }
}
