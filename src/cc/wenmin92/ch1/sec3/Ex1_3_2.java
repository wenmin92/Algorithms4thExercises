package cc.wenmin92.ch1.sec3;

import edu.princeton.cs.algs4.Stack;
// import edu.princeton.cs.algs4.StdOut;

/**
 * 给定以下输入，java Stack 的输出是什么？
 * it was - the best - of times - - - it was - the - -
 */
public class Ex1_3_2 {
    public static void main(String[] args) {
        // String s = "it was - the best - of times - - - it was - the - -";
        // String[] words = s.split(" ");
        // Stack<String> stack = new Stack<>();
        // for (String word : words) {
        //     if (!word.equals("-")) {
        //         stack.push(word);
        //     } else {
        //         StdOut.print(stack.pop() + " ");
        //     }
        // }
        // StdOut.println("(" + stack.size() + " left on stack)");
        Stack.main(null); // was best times of the was the it (1 left on stack)
    }
}
