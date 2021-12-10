package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

/**
 * 为 Transaction 类完成练习 1.3.16。
 */
public class Ex1_3_17 {
    public static void main(String[] args) {
        StdOut.println(Arrays.toString(readTransactions()));
    }

    public static Transaction[] readTransactions() {
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readLine());
        }
        int N = q.size();
        Transaction[] transactions = new Transaction[N];
        for (int i = 0; i < N; i++) {
            transactions[i] = new Transaction(q.dequeue());
        }
        return transactions;
    }
}
