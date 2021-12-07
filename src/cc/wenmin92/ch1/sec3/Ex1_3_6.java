package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 下面这段代码对队列 q 进行了什么操作？
 * <pre>
 * Stack<String> stack = new Stack<String>();
 * while (!q.isEmpty())
 *    stack.push(q.dequeue());
 * while (!stack.isEmpty())
 *    q.enqueue(stack.pop());
 * </pre>
 *
 * 解析: 对队列 q 进行逆序. 队列先进先出, 栈后进先出. 先放入栈中, 再从栈中取出, 顺序相反.
 */
public class Ex1_3_6 {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i + "");
        }
        StdOut.println("Before: " + q); // Before: 0 1 2 3 4 5 6 7 8 9

        Stack<String> stack = new Stack<>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());

        StdOut.println(" After: " + q); //  After: 9 8 7 6 5 4 3 2 1 0
    }
}
