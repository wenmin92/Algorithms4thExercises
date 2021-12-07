package cc.wenmin92.ch1.sec3;

/**
 * 为 Stack 添加一个方法 peek()，返回栈中最近添加的元素（而不弹出它）。
 */
public class Ex1_3_7 {
    private static class Stack<Item> {
        private static class Node<Item> {
            Node<Item> next;
            Item item;
        }

        private Node<Item> first;

        public void push(Item item) {
            Node<Item> oldFirst = first;
            first = new Node<>();
            first.item = item;
            first.next = oldFirst;
        }

        public Item pop() {
            Item item = first.item;
            first = first.next;
            return item;
        }

        public Item peek() {
            return first.item;
        }
    }
}
