package offer.stackqueue;

import java.util.ArrayList;

/**
 * 用两个栈实现队列
 */
public class Q09 {
    public static void main(String[] args) {
        Q09 q09 = new Q09();
        q09.appendTail(1);
        q09.appendTail(2);
        q09.appendTail(3);
        System.out.println(q09.deleteHead());
        System.out.println(q09.deleteHead());
        System.out.println(q09.deleteHead());
    }

    ArrayList<Integer> left = new ArrayList<>();
    ArrayList<Integer> right = new ArrayList<>();

    public Q09() {
    }

    public void appendTail(int value) {
        left.add(value);
    }

    public int deleteHead() {
        if (right.isEmpty()) {
            if (left.isEmpty()) {
                return -1;
            } else {
                for (int i = left.size() - 1; i >= 0; i--) {
                    right.add(left.remove(i));
                }
                return right.remove(right.size() - 1);
            }
        }
        return right.remove(right.size() - 1);
    }
}
