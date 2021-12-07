package cc.wenmin92.ch1.sec3;

import java.util.Iterator;

public class P98_Bag<Item> implements Iterable<Item> {
    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    private int N;
    private Node<Item> first;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        P98_Bag<String>[] a= new P98_Bag[8];
    }
}
