package offer.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中的逆序对
 */
public class Q51 {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
    }

    public static int reversePairs(int[] nums) {
        // 归并排序，排序过程中计算逆序对
        // 从最小数开始归并，会导致逆序对重复计算，比如左边是3，右边是1、2，会算成（3，1），（3，1），（3，2）
        // 所以要从最大数开始归并，这样左边的大数归并后就去掉了

        int len;
        if ((len = nums.length) <= 1) {
            return 0;
        }

        int mid = len / 2;

        int[] aNums = Arrays.copyOfRange(nums, 0, mid);
        int[] bNums = Arrays.copyOfRange(nums, mid, len);

        int sum = reversePairs(aNums) + reversePairs(bNums);

        int aP = aNums.length - 1, bP = bNums.length - 1, p = len - 1;
        while (aP >= 0 && bP >= 0) {
            if (aNums[aP] <= bNums[bP]) {
                nums[p--] = bNums[bP--];
            } else {
                sum += (bP + 1);
                nums[p--] = aNums[aP--];
            }
        }
        while (aP >= 0) {
            nums[p--] = aNums[aP--];
        }
        while (bP >= 0) {
            nums[p--] = bNums[bP--];
        }

        return sum;
    }

    /**
     * 超时
     */
    public static int reversePairs2(int[] nums) {
        // 先遍历数组，记录每个数出现的次数
        // 再遍历一次数组，每遍历一个数，计算比他小的数的总数，然后删除自己的总数

        int len;
        if ((len = nums.length) <= 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int t;

        for (int i = 0; i < len; ++i) {
            t = nums[i];
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }

        int sum = 0;

        for (int i = 0; i < len; ++i) {
            t = nums[i];
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() < t) {
                    sum += entry.getValue();
                }
            }
            if (map.get(t) > 1) {
                map.put(t, map.get(t) - 1);
            } else {
                map.remove(t);
            }
        }

        return sum;
    }

    /**
     * 超时
     */
    public int reversePairs1(int[] nums) {
        // 迭代，O(n^2)

        int len;
        if ((len = nums.length) <= 1) {
            return 0;
        }

        int sum = 0;

        int t;
        for (int i = 0; i < len; ++i) {
            t = nums[i];
            for (int j = i + 1; j < len; ++j) {
                if (nums[j] < t) {
                    sum++;
                }
            }
        }

        return sum;
    }
}
