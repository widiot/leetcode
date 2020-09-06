package offer.array;

/**
 * 扑克牌中的顺子
 */
public class Q61 {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{11, 9, 12, 0, 0}));
    }

    public static boolean isStraight(int[] nums) {
        // 冒泡排序过程中，数空缺的位置数量，从1开始
        // 并记录0的数量，如果空缺的数量小于等于0的数量，则是顺子

        int len = nums.length;

        int zero = 0, absent = 0;
        int t;
        for (int i = len - 1; i >= 0; --i) { // 每次要排好的位置，0要包含在内，用于记录
            for (int j = 0; j < i; ++j) { // 两两比较
                if (nums[j] > nums[j + 1]) {
                    t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
            if (i < (len - 1)) {
                if (nums[i] == 0) {
                    ++zero;
                } else {
                    t = nums[i + 1] - nums[i] - 1;
                    if (t < 0) {
                        return false;
                    }
                    absent += t;
                }
            }
        }

        if (absent <= zero) {
            return true;
        }
        return false;
    }
}
