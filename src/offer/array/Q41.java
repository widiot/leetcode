package offer.array;

import java.util.LinkedList;

/**
 * 数据流中的中位数
 */
public class Q41 {

    private LinkedList<Integer> list;

    /**
     * initialize your data structure here.
     */
    public Q41() {
        list = new LinkedList<>();
    }

    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        int i = 0;
        for (Integer n : list) {
            if (n > num) {
                break;
            }
            ++i;
        }
        list.add(i, num);
    }

    public double findMedian() {
        if (list.isEmpty()) {
            return 0.0;
        }
        int len = list.size();
        if (len % 2 == 0) {
            int left = (len - 1) / 2;
            return (list.get(left) + list.get(left + 1)) / 2.0;
        } else {
            return list.get(len / 2);
        }
    }
}
