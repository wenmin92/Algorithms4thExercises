package cc.wenmin92.ch1.sec2;

/**
 * 以下递归函数的返回值是什么？
 * <pre>
 * public static String mystery(String s)
 * {
 *    int N = s.length();
 *    if (N <= 1) return s;
 *    String a = s.substring(0, N/2);
 *    String b = s.substring(N/2, N);
 *    return mystery(b) + mystery(a);
 * }
 * </pre>
 *
 * 解析: 字符串反转
 */
public class Ex1_2_7 {
    public static void main(String[] args) {
        System.out.println(mystery("abcdefg")); // gfedcba
    }

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }
}
