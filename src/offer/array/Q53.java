package offer.array;

/**
 * 在排序数组中查找数字
 */
public class Q53 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,3}, 2));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int idx = find(nums, target);
        int i = 0;
        for (; idx < nums.length; ++idx) {
            if (nums[idx] == target) {
                ++i;
            } else {
                break;
            }
        }
        return i;
    }

    public static int find(int[] nums, int t) {
        int s = 0, e = nums.length - 1;
        int h;
        while (s <= e) {
            h = (s + e) / 2;
            if (nums[h] >= t) {
                e = h - 1;
            } else {
                s = h + 1;
            }
        }
        return s;
    }
}
