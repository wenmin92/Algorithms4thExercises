import edu.princeton.cs.algs4.StdOut;

public class Test {
    public static void main(String[] args) {
        StdOut.println(mystery(2, 10));
    }

    public static int mystery(int a, int b) {
        if (a == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }
}
