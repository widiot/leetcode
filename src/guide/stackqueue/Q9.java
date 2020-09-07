package guide.stackqueue;

import java.util.LinkedList;

/**
 * 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class Q9 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        cQueue.appendTail(5);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    static class CQueue {
        private final LinkedList<Integer> push; // 用于push的队列
        private final LinkedList<Integer> pop; // 用于pop的队列，pop为空时才能倒，从push倒到pop时要全倒

        public CQueue() {
            push = new LinkedList<>();
            pop = new LinkedList<>();
        }

        public void appendTail(int value) {
            push.push(value);
        }

        public int deleteHead() {
            if (pop.isEmpty()) {
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
                if (pop.isEmpty()) {
                    return -1;
                }
            }
            return pop.pop();
        }
    }
}
