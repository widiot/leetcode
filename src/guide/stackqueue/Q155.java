package guide.stackqueue;

import java.util.LinkedList;

/**
 * 最小栈
 * https://www.nowcoder.com/practice/05e57ce2cd8e4a1eae8c3b0a7e9886be?tpId=101&&tqId=33073&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 */
public class Q155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    static class MinStack {
        private final LinkedList<Integer> stack;
        private final LinkedList<Integer> maxStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            maxStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            int min = x;
            if (!maxStack.isEmpty()) {
                int top = maxStack.peek();
                min = Math.min(min, top);
            }
            maxStack.push(min);
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            stack.pop();
            maxStack.pop();
        }

        public int top() {
            if (stack.isEmpty()) {
                return 0;
            }
            return stack.peek();
        }

        public int getMin() {
            if (maxStack.isEmpty()) {
                return 0;
            }
            return maxStack.peek();
        }
    }
}