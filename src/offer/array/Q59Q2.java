package offer.array;

import java.util.LinkedList;

/**
 * 队列的最大值
 */
public class Q59Q2 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(3);
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(1);
        System.out.println(maxQueue.max_value()); // 3
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value()); // 2
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value()); // 2
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value()); // 1
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value()); // -1
    }

    static class MaxQueue {

        private final LinkedList<Integer> q;
        private final LinkedList<Integer> maxQ;

        public MaxQueue() {
            q = new LinkedList<>();
            maxQ = new LinkedList<>();
        }

        public int max_value() {
            if (maxQ.isEmpty()) {
                return -1;
            }
            return maxQ.peek();
        }

        public void push_back(int value) {
            q.offer(value);
            int i = 0;
            if (!maxQ.isEmpty()) {
                for (; i < maxQ.size(); ++i) {
                    if (maxQ.get(i) <= value) {
                        break;
                    }
                }
            }
            maxQ.add(i, value);
        }

        public int pop_front() {
            if (q.isEmpty()) {
                return -1;
            }
            int value = q.poll();
            int max = maxQ.peek() == null ? -1 : maxQ.peek();
            if (max == value) {
                maxQ.poll();
            } else {
                maxQ.removeFirstOccurrence(value);
            }
            return value;
        }
    }
}