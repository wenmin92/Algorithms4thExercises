package cc.wenmin92.ch1.sec2;

/**
 * 设 a[] 和 b[] 均为长数百万的整形数组。以下代码的作用是什么？有效吗？
 * int[] t = a; a = b; b = t;
 * 答：这段代码会将它们交换。它的效率不可能再高了，因为它复制的是引用而不需要复制数百万
 * 个元素。
 */
public class Ex1_2_8 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] t = a;
        a = b;
        b = t;
    }
}
