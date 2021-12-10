package cc.wenmin92.ch1.sec3;

import static cc.wenmin92.ch1.sec3.LinkUtils.genLinks;
import static cc.wenmin92.ch1.sec3.LinkUtils.printLinks;

/**
 * 为什么下面这段代码和上一道题中的代码效果不同？
 * x.next = t;
 * t.next = x.next;
 * 答：在更新 t.next 时，x.next 已经不再指向 x 的后续结点，而是指向 t 本身！
 *
 * 解析: 第一行 x 指向 t, 第二行 t 又指向 t, 导致 t 指向自身
 */
public class Ex1_3_23 {
    public static void main(String[] args) {
        Node<String> links = genLinks(5);
        Node<String> t = new Node<>("t");

        printLinks(links);

        links.next = t;
        t.next = links.next;

        printLinks(links);

        // output
        // [t -> t -> t...]
    }
}
