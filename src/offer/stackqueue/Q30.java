package offer.stackqueue;

import java.util.LinkedList;

/**
 * 包含min函数的栈
 */
public class Q30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min()); // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top()); // --> 返回 0.
        System.out.println(minStack.min()); // --> 返回 -2.
    }

    private static class MinStack {
        private final LinkedList<Integer> stack;
        private final LinkedList<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.add(x);
            int min = x;
            if (!minStack.isEmpty()) {
                min = minStack.getLast();
            }
            minStack.add(Math.min(x, min));
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.removeLast();
                minStack.removeLast();
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.getLast();
            }
            return 0;
        }

        public int min() {
            if (!minStack.isEmpty()) {
                return minStack.getLast();
            }
            return 0;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
