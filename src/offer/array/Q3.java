package offer.array;

/**
 * 数组中重复的数组
 */
public class Q3 {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public static int findRepeatNumber(int[] nums) {
        int t;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    t = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = t;
                    continue;
                }
            }
            i++;
        }
        return -1;
    }
}
